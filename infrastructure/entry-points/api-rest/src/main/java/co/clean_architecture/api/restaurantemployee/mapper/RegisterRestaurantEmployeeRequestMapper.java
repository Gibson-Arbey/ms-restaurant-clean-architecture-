package co.clean_architecture.api.restaurantemployee.mapper;

import co.clean_architecture.api.restaurantemployee.request.RegisterRestaurantEmployeeRequest;
import co.clean_architecture.usecase.restaurant.command.RegisterRestaurantEmployeeCommand;

public class RegisterRestaurantEmployeeRequestMapper {

    public static RegisterRestaurantEmployeeCommand toCommand(RegisterRestaurantEmployeeRequest registerRestaurantEmployeeRequest){
        return new RegisterRestaurantEmployeeCommand(
                registerRestaurantEmployeeRequest.getRestaurantId(),
                registerRestaurantEmployeeRequest.getEmployeeId()
        );
    }
}
