package lambda_functions_tasks.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> vegetables = new ArrayList<>();
        vegetables.add("огурец");
        vegetables.add("помидор");
        vegetables.add("картошка");
        vegetables.add("перец");
        vegetables.add("кабачок");

        Function<List<String>, List<Integer>> function = strings -> {
            List<Integer> lengths = new ArrayList<>();
            for (String str : strings) {
                lengths.add(str.length());
            }
            return lengths;
        };

        System.out.println(function.apply(vegetables));
    }
}
