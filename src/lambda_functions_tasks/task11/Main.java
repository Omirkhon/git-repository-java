package lambda_functions_tasks.task11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(9);
        nums.add(11);
        nums.add(3);
        nums.add(5);

        Predicate<List<Integer>> predicate = integers -> {
            for (int num : integers) {
                if (num%2==0) {
                    return true;
                }
            }
            return false;
        };

        System.out.println("В списке есть четные числа: "+predicate.test(nums));
    }
}
