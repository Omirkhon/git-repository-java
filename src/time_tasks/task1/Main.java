package time_tasks.task1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static final LocalDate CURRENT_DATE = LocalDate.now();
    static Scanner scanner = new Scanner(System.in);
    static Map<String, LocalDate> friends = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addFriend();
                    break;
                case 2:
                    daysBeforeBirthday();
                    break;
                case 3:
                    printAllFriends();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    public static void addFriend() {
        System.out.print("Имя друга: ");
        String name = scanner.next();
        System.out.print("Введите дату (год месяц день): ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        LocalDate birthday = LocalDate.of(year, month, day);
        friends.put(name, birthday);
    }

    public static void daysBeforeBirthday() {
        if (friends.isEmpty()) {
            System.out.println("У вас нет друзей.");
        } else {
            System.out.print("Имя друга: ");
            String name = scanner.next();
            if (friends.containsKey(name)) {
                int birthday = friends.get(name).getDayOfYear();
                if (CURRENT_DATE.getDayOfYear() > birthday) {
                    System.out.println("Осталось "+(birthday - CURRENT_DATE.getDayOfYear() + 365)
                            +" дней. Исполнится "+(1+ CURRENT_DATE.getYear()-friends.get(name).getYear()));
                } else {
                    System.out.println("Осталось "+(birthday - CURRENT_DATE.getDayOfYear())
                            +" дней. Исполнится "+(CURRENT_DATE.getYear()-friends.get(name).getYear()));
                }
            }
        }
    }

    public static void printAllFriends() {
        if (friends.isEmpty()) {
            System.out.println("У вас нет друзей.");
        } else {
            for (String friend : friends.keySet()) {
                System.out.println(friend+" - "+friends.get(friend).getYear()+" "
                        +getMonth(friends.get(friend).getMonthValue())+" " +friends.get(friend).getDayOfMonth());
            }
        }
    }

    public static String getMonth(int month) {
        switch (month) {
            case 1: return "января";
            case 2: return "февраля";
            case 3: return "марта";
            case 4: return "апреля";
            case 5: return "мая";
            case 6: return "июня";
            case 7: return "июля";
            case 8: return "августа";
            case 9: return "сентября";
            case 10: return "октября";
            case 11: return "ноября";
            case 12: return "декабря";
            default: return "";
        }
    }

    public static void printMenu() {
        System.out.print("1. Добавить друга\n" +
                "2. Узнать сколько дней осталось до дня рождения друга\n" +
                "3. Вывод всех друзей\n" +
                "0. Выйти\n" +
                "Выберите действие: ");
    }
}
