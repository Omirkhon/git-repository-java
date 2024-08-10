package exception_task_2;

import java.util.Scanner;

public class Main {
    static final int MIN_AGE = 18;

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        validateUser(getUserByLoginAndPassword(login, password));
        System.out.println("Доступ предоставлен");
    }

    public static User[] getUsers() {
        User user1 = new User("jhon", "jhon@gmail.com", "pass", 24);
        User user2 = new User("toblerone", "toblerone@gmail.com", "password", 18);
        User user3 = new User("alpengold", "alpengold@gmail.com", "aaa", 19);
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.age>=MIN_AGE) {
            return;
        }
        throw new AccessDeniedException("Вам должно быть 18 лет.");
    }
}
