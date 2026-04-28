package co.clean_architecture.model.restaurant.exception;

import co.clean_architecture.model.exception.DomainException;
import co.clean_architecture.model.exception.ErrorTypeEnum;

public class NotRestaurantOwnerException extends DomainException {
    public NotRestaurantOwnerException(String message) {
        super(message);
    }

    @Override
    public String getCode() {
        return "NOT_RESTAURANT_OWNER";
    }

    @Override
    public ErrorTypeEnum getErrorType() {
        return ErrorTypeEnum.VALIDATION;
    }
}
