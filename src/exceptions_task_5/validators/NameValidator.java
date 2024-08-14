package exceptions_task_5.validators;

import exceptions_task_5.exceptions.ValidateException;
import exceptions_task_5.exceptions.ValidateNameException;

public class NameValidator implements Validator {
    @Override
    public void validate(String value) throws ValidateException {
        if (value.isBlank()) {
            throw new ValidateNameException("Имя не должно быть пустым");
        }
    }
}
