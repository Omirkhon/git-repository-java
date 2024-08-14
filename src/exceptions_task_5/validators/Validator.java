package exceptions_task_5.validators;

import exceptions_task_5.exceptions.ValidateException;

public interface Validator {
    void validate(String value) throws ValidateException;
}
