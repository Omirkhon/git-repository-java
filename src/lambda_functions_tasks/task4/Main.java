package lambda_functions_tasks.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        List<String> vegetables = new ArrayList<>();
        vegetables.add("огурец");
        vegetables.add("помидор");
        vegetables.add("картошка");
        vegetables.add("перец");
        vegetables.add("кабачок");

        UnaryOperator<List<String>> unaryOperator = strings -> {
            List<String> newList = new ArrayList<>();
            for (String str : strings) {
                newList.add(str.toUpperCase());
            }
            return newList;
        };

        System.out.println(unaryOperator.apply(vegetables));
    }
}
