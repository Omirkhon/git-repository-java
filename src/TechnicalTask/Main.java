package TechnicalTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1){
                stepTracker.addNewNumberStepsPerDay(scanner);
            } else if (choice == 2) {
                stepTracker.changeStepGoal(scanner);
            } else if (choice == 3) {
                stepTracker.printStatistic(scanner);
            } else {
                break;
            }
        }
    }

    static void printMenu() {
        System.out.println("1) Ввести количество шагов за определенный день");
        System.out.println("2) Изменить цель по количеству шагов в день");
        System.out.println("3) Напечатать статистику за определённый месяц");
        System.out.println("4) Выйти из приложения");
    }
}