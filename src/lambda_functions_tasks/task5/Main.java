package lambda_functions_tasks.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            nums.add(i);
        }
        UnaryOperator<List<Integer>> unaryOperator = integers -> {
            List<Integer> squareNums = new ArrayList<>();
            for (int num : integers) {
                squareNums.add(num*num);
            }
            return squareNums;
        };

        System.out.println(unaryOperator.apply(nums));
    }
}
