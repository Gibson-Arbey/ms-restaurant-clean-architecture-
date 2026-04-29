package co.clean_architecture.usecase.dish;

import co.clean_architecture.model.dish.Dish;
import co.clean_architecture.model.dish.gateways.DishRepository;
import co.clean_architecture.model.restaurant.exception.NotRestaurantOwnerException;
import co.clean_architecture.model.restaurant.gateways.RestaurantRepository;
import co.clean_architecture.usecase.dish.command.RegisterDishCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterDishUseCase {

    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public Dish execute(RegisterDishCommand command, Long ownerId) {
        if(!restaurantRepository.existsByIdAndOwnerId(command.restaurantId(), ownerId)) {
            throw new NotRestaurantOwnerException("Restaurant not found for the given restaurant ID and owner ID");
        }

        return dishRepository.save(
                Dish.create(
                        command.name(),
                        command.price(),
                        command.description(),
                        command.imgUrl(),
                        command.category(),
                        command.restaurantId()
                )
        );

    }
}
