package co.clean_architecture.usecase.restaurant;

import co.clean_architecture.model.exception.InvalidFieldException;
import co.clean_architecture.model.restaurant.Restaurant;
import co.clean_architecture.model.restaurant.gateways.RestaurantRepository;
import co.clean_architecture.model.user.exception.OwnerNotExistsException;
import co.clean_architecture.model.user.gateways.UserRepository;
import co.clean_architecture.usecase.restaurant.command.RegisterRestaurantCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterRestaurantUseCase {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository  userRepository;

    public Restaurant execute(RegisterRestaurantCommand command) {
        validateOwnerExists(command.ownerId());

        Restaurant restaurant = Restaurant.create(
                command.name(),
                command.nit(),
                command.address(),
                command.phone(),
                command.logoUrl(),
                command.ownerId()
        );

        return restaurantRepository.save(restaurant);
    }

    private void validateOwnerExists(Long ownerId) {
        if(ownerId == null){
            throw new InvalidFieldException("Owner ID cannot be null.");
        }

        if (!userRepository.existsOwnerById(ownerId)) {
            throw new OwnerNotExistsException("Owner with ID " + ownerId + " does not exist.");
        }
    }
}
