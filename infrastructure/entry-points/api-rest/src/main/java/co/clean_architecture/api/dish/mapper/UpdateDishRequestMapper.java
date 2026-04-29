package co.clean_architecture.api.dish.mapper;

import co.clean_architecture.api.dish.request.UpdateDishRequest;
import co.clean_architecture.usecase.dish.command.UpdateDishCommand;

public class UpdateDishRequestMapper {

    public static UpdateDishCommand toCommand(UpdateDishRequest request) {
        if(request == null)  return null;
        return new UpdateDishCommand(
            request.getDescription(),
            request.getPrice()
        );
    }
}
