package lambda_functions_tasks.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        List<String> vegetables = new ArrayList<>();
        vegetables.add("Огурец");
        vegetables.add("Помидор");
        vegetables.add("Картошка");
        vegetables.add("Перец");
        vegetables.add("Кабачок");

        UnaryOperator<List<String>> unaryOperator = list -> {
            list.sort(new NewComparator());
            return list;
        };

        System.out.println(unaryOperator.apply(vegetables));
    }
}
