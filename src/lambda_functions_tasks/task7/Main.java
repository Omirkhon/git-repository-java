package lambda_functions_tasks.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        Function<List<Integer>, Integer> function = integers -> {
            int product = 1;
            for (int num : integers) {
                product *= num;
            }
            return product;
        };

        System.out.println(function.apply(numbers));
    }
}

interface Lambda {
    int findProduct(List<Integer> nums);
}
