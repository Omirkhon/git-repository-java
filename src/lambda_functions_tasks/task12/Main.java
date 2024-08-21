package lambda_functions_tasks.task12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(9);
        nums.add(11);
        nums.add(4);
        nums.add(20);

        Function<List<Integer>, Integer> function = integers -> {
            int count = 0;
            for (int num : integers) {
                if (num%2==0) {
                    count += num;
                }
            }
            return count;
        };

        System.out.println(function.apply(nums));
    }
}
