package co.clean_architecture.model.user.exception;

import co.clean_architecture.model.exception.DomainException;
import co.clean_architecture.model.exception.ErrorTypeEnum;

public class EmployeeNotExistsException extends DomainException {

    public EmployeeNotExistsException(String message) {
        super(message);
    }

    @Override
    public String getCode() {
        return "EMPLOYEE_NOT_EXISTS";
    }

    @Override
    public ErrorTypeEnum getErrorType() {
        return ErrorTypeEnum.NOT_FOUND;
    }
}
