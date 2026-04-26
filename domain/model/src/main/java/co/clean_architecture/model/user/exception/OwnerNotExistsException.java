package co.clean_architecture.model.user.exception;

import co.clean_architecture.model.exception.DomainException;
import co.clean_architecture.model.exception.ErrorTypeEnum;

public class OwnerNotExistsException extends DomainException {

    public OwnerNotExistsException(String message) {
        super(message);
    }
    @Override
    public String getCode() {
        return "OWNER_NOT_EXISTS";
    }

    @Override
    public ErrorTypeEnum getErrorType() {
        return ErrorTypeEnum.NOT_FOUND;
    }
}
