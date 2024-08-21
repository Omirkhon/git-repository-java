package lambda_functions_tasks.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Апельсин");
        fruits.add("Банан");
        fruits.add("Виноград");
        fruits.add("Груша");
        fruits.add("Дыня");

        Function<List<String>, Integer> function = strings -> {
            int maxLength = 0;
            for (String str : strings) {
                if (str.length() > maxLength) {
                    maxLength = str.length();
                }
            }
            return maxLength;
        };

        System.out.println(function.apply(fruits));
    }
}
