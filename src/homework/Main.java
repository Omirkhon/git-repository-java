package homework;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();
        while (true){
            System.out.println(" ");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Вывести список задач");
            System.out.println("3. Удалить задачу");
            System.out.println("0. Выйти");
            System.out.print("Введите действие: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice == 1){
                addTask(toDoList);
            }
            else if(choice == 2){
                showTasks(toDoList);
            }
            else if(choice == 3){
                removeTask(toDoList);
            }
            else if(choice == 0){
                break;
            }
            else{
                System.out.println("Вы выбрали неверное действие");
            }
        }
    }
    static void addTask(ArrayList<String> list){
        System.out.print("Введите задачу для планирования: ");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        list.add(action);
        System.out.println("Задача добавлена");
    }
    static void showTasks(ArrayList<String> list){
        if(list.isEmpty()){
            System.out.println("Нет запланированных дел");
        }
        else {
            System.out.println("Список запланированных дел:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i));
            }
        }
    }
    static void removeTask(ArrayList<String> list){
        showTasks(list);
        System.out.print("Введите номер для удаления: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if(number > 0 && number <= list.size()){
            System.out.println("Удалена задача: "+"\""+list.get(number-1)+"\"");
            list.remove(number-1);
        }
        else{
            System.out.println("Некорректный номер");
        }
    }
}