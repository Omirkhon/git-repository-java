package lambda_functions_tasks.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Апельсин");
        fruits.add("Банан");
        fruits.add("Виноград");
        fruits.add("Груша");
        fruits.add("Дыня");

        UnaryOperator<List<String>> unaryOperator = strings -> {
            List<String> sortedStr = new ArrayList<>();
            for (String str : strings) {
                if (str.length()>7) {
                    sortedStr.add(str);
                }
            }
            return sortedStr;
        };

        System.out.println(unaryOperator.apply(fruits));
    }
}
