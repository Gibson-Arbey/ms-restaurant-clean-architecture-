package co.clean_architecture.api.restaurant.mapper;

import co.clean_architecture.api.restaurant.request.RegisterRestaurantRequest;
import co.clean_architecture.usecase.restaurant.command.RegisterRestaurantCommand;

public class RegisterRestaurantRequestMapper {

    public static RegisterRestaurantCommand toCommand(RegisterRestaurantRequest request) {
        return new RegisterRestaurantCommand(
            request.getName(),
            request.getNit(),
            request.getAddress(),
            request.getPhone(),
            request.getLogoUrl(),
            request.getOwnerId()
        );
    }
}
