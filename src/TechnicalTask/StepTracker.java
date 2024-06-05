package TechnicalTask;

import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    public StepTracker(){
        for (int i = 0; i< monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay(Scanner scanner) {
        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt();
        System.out.print("Введите день от 1 до 30 (включительно): ");
        int day = scanner.nextInt();
        System.out.print("Введите количество шагов: ");
        int steps = scanner.nextInt();
        if (month > 0 && month < 13 && day>0 && day<31 && steps>=0) {
            MonthData monthData = monthToData[month-1];
            monthData.days[day-1] = steps;
            System.out.println("Было добавлено "+steps+" шагов на дату на "+(day<10?"0"+day:""+day)+"."+(month<10?"0"+month:""+month));
        } else {
            System.out.println("Введено недопустимое значение.");
        }
    }

    void changeStepGoal(Scanner scanner) {
        System.out.println("Текущая цель "+goalByStepsPerDay);
        System.out.print("Введите новую цель: ");
        int newGoal = scanner.nextInt();
        if (newGoal > 0) {
            goalByStepsPerDay = newGoal;
            System.out.println("Новая цель сохранена.");
        } else {
            System.out.println("Недопустимое значение.");
        }
    }

    void printStatistic(Scanner scanner) {
        System.out.print("Введите число месяца: ");
        int month = scanner.nextInt();
        if (month > 0 && month < 13) {
            MonthData monthData = monthToData[month - 1];
            monthData.printDaysAndStepsFromMonth();
            Converter converter = new Converter();
            System.out.println("Общее количество шагов за месяц: "+monthData.sumStepsFromMonth());
            System.out.println("Максимальное пройденное количество шагов за месяц: "+monthData.maxSteps());
            System.out.println("Среднее количество шагов за месяц: "+monthData.sumStepsFromMonth()/30);
            System.out.println("Пройденная дистанция за месяц в км: "+converter.convertToKm(monthData.sumStepsFromMonth()));
            System.out.println("Количество сожжённых килокалорий за месяц: "+converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
            System.out.println("Лучшая серия за месяц: "+monthData.bestSeries(goalByStepsPerDay));
        } else {
            System.out.println("Некорректное число месяца.");
        }
    }
}