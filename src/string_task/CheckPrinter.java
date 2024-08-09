package string_task;

import java.util.Scanner;

public class CheckPrinter {

    private static final int maxItemLength = 8;
    private static final int maxNumLength = 5;
    private static final int maxPriceLength = 6;
    public static void printCheck(String[] items) {
        for (String item : items) {
            String[] split = item.split(", ");
            System.out.printf("%-2"+maxItemLength+"s" +"%-2"+maxNumLength+"s" + "%-"+maxPriceLength+"s\n", split[0], split[1], split[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество записей:");
        int n = Integer.parseInt(scanner.nextLine());
        String[] values = new String[n];
        for (int i = 0; i < n; ++i)
            values[i] = scanner.nextLine();
        printCheck(values);
    }
}
