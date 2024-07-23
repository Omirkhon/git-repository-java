package HashTableHw;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static Map<Long, User> users2 = new LinkedHashMap<>();


    public static void main(String[] args) {
        for (long i = 1; i <= 1_000_000L; i++) {
            users.add(new User(i, "Имя " + i));
        }

        for (long i = 1; i <= 1_000_000L; i++) {
            users2.put(i, new User(i, "Имя " + i));
        }

        final long startTime = System.nanoTime();
        User user = findUser(378_366L);
        final long endTime = System.nanoTime();
        System.out.println("Найден пользователь: " + user);
        System.out.println("Поиск занял " + (endTime - startTime) + " наносекунд.");

        final long startTime2 = System.nanoTime();
        User user2 = users2.get(378_366L);
        final long endTime2 = System.nanoTime();
        System.out.println("Найден пользователь: " + user2);
        System.out.println("Поиск занял " + (endTime2 - startTime2) + " наносекунд.");

        System.out.println("Поиск был ускорен в "+(endTime - startTime)/(endTime2 - startTime2)+" раза");
    }

    private static User findUser(Long userId) {
        for (User user : users) {
            if (user.id.equals(userId)) {
                return user;
            }
        }
        return null;
    }

    static class User {
        Long id;
        String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "User{id=" + id + ", name='" + name + "'}";
        }
    }
}