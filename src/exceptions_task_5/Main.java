package exceptions_task_5;

import exceptions_task_5.exceptions.ValidateException;
import exceptions_task_5.exceptions.ValidateNameException;
import exceptions_task_5.exceptions.ValidatePasswordException;
import exceptions_task_5.storage.PasswordMemoryStorage;
import exceptions_task_5.storage.PasswordStorage;
import exceptions_task_5.validators.NameValidator;
import exceptions_task_5.validators.PasswordLengthValidator;
import exceptions_task_5.validators.PasswordStrengthValidator;
import exceptions_task_5.validators.Validator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Validator> passwordValidators = List.of(
            new PasswordLengthValidator(5), new PasswordStrengthValidator()
    );

    private static final List<Validator> nameValidators = List.of(new NameValidator()); // поработайте со списком

    public static void main(String[] args) {
        loop();
    }

    public static void loop() {
        while (true) {
            final String action = getAction();
            if ("1".equals(action)) {
                addUser();
            } else if ("2".equals(action)) {
                showUserPassword();
            } else {
                break;
            }
        }
    }

    private static void checkValidatorRules(
            final List<Validator> validators, final String value
    ) throws ValidateException {
        for (Validator validator : validators) {
            validator.validate(value);
        }
    }

    private static void addUser() {
        final PasswordStorage storage = new PasswordMemoryStorage();
        try {
            storage.open();
            System.out.println("Введите имя пользователя => ");
            final String name = scanner.nextLine();
            try {
                checkValidatorRules(nameValidators, name);
            } catch (ValidateNameException e) {
                System.out.println("Ошибка валидации имени: " + e.getMessage());
            }
            System.out.println("Введите пароль пользователя => ");
            final String password = scanner.nextLine();
            try {
                checkValidatorRules(passwordValidators, password);
            } catch (ValidatePasswordException e) {
                System.out.println("Ошибка валидации пароля: " + e.getMessage());
            }
            storage.store(name, password);
        } catch (ValidateException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка работы с хранилищем: " + e.getMessage());
        } finally {
            storage.close();
        }
    }

    private static void showUserPassword() {
        final PasswordStorage storage = new PasswordMemoryStorage();
        try {
            storage.open();
            System.out.println("Введите имя пользователя => ");
            final String name = scanner.nextLine();
            try {
                checkValidatorRules(nameValidators, name);
            } catch (ValidateNameException e) {
                System.out.println("Ошибка валидации имени: " + e.getMessage());
            }
            final String password = storage.get(name);
            System.out.println(String.format("Пароль пользователя %s = %s", name, password));
        } catch (ValidateException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка работы с хранилищем: " + e.getMessage());
        } finally {
            storage.close();
        }
    }

    private static String getAction() {
        System.out.println("1 - добавить пользователя с паролем");
        System.out.println("2 - отобразить пароль пользователя");
        System.out.println("другие символы - выход");
        System.out.println("Выберите действие => ");
        return scanner.nextLine();
    }
}
