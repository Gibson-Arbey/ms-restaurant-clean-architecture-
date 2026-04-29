package co.clean_architecture.api.dish.mapper;

import co.clean_architecture.api.dish.request.RegisterDishRequest;
import co.clean_architecture.model.dish.CategoryEnum;
import co.clean_architecture.usecase.dish.command.RegisterDishCommand;

public class RegisterDishRequestMapper {

    public static RegisterDishCommand toCommand(RegisterDishRequest request) {
        if(request == null) return null;
        return new RegisterDishCommand(
            request.getName(),
            request.getPrice(),
            request.getDescription(),
            request.getImgUrl(),
            CategoryEnum.valueOf(request.getCategory().toUpperCase()),
            request.getRestaurantId()
        );
    }
}
