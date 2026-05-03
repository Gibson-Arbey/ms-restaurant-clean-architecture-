package co.clean_architecture.usecase.restaurant;

import co.clean_architecture.model.restaurant.exception.NotRestaurantOwnerException;
import co.clean_architecture.model.restaurant.gateways.RestaurantRepository;
import co.clean_architecture.model.restaurantemployee.RestaurantEmployee;
import co.clean_architecture.model.restaurantemployee.gateways.RestaurantEmployeeRepository;
import co.clean_architecture.model.user.exception.EmployeeNotExistsException;
import co.clean_architecture.model.user.gateways.UserRepository;
import co.clean_architecture.usecase.restaurant.command.RegisterRestaurantEmployeeCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterEmployeeRestaurantUseCase {

    private final UserRepository  userRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantEmployeeRepository restaurantEmployeeRepository;

    public void execute(RegisterRestaurantEmployeeCommand registerRestaurantEmployeeCommand, Long ownerId) {
        RestaurantEmployee restaurantEmployee = RestaurantEmployee.create(
                registerRestaurantEmployeeCommand.restaurantId(),
                registerRestaurantEmployeeCommand.employeeId()
        );

        if(!restaurantRepository.existsByRestaurantId(registerRestaurantEmployeeCommand.employeeId())) {
            throw new NotRestaurantOwnerException("Restaurant not found for the given restaurant ID");
        }

        if(restaurantRepository.existsByRestaurantIdAndOwnerId(registerRestaurantEmployeeCommand.restaurantId(), ownerId)) {
            throw new NotRestaurantOwnerException("Restaurant not found for the given restaurant ID and owner ID");
        }

        if(!userRepository.existsEmployeeById(registerRestaurantEmployeeCommand.employeeId())) {
            throw new EmployeeNotExistsException("Employee not found for the given employee ID");
        }

        restaurantEmployeeRepository.save(restaurantEmployee);
    }
}
