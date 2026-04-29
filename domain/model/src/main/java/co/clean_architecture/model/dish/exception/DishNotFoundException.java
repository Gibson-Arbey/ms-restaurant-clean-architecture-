package co.clean_architecture.model.dish.exception;

import co.clean_architecture.model.exception.DomainException;
import co.clean_architecture.model.exception.ErrorTypeEnum;

public class DishNotFoundException extends DomainException {

    public DishNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getCode() {
        return "DISH_NOT_FOUND";
    }

    @Override
    public ErrorTypeEnum getErrorType() {
        return ErrorTypeEnum.NOT_FOUND;
    }
}
