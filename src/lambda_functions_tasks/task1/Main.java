package lambda_functions_tasks.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Lambda lambda = (nums1) -> {
            List<Integer> evenNums = new ArrayList<>();
            for (int num : nums1) {
                if (num%2 == 0) {
                    evenNums.add(num);
                }
            }
            return evenNums;
        };
        System.out.println(lambda.removeOddNums(nums));
    }
}

interface Lambda {
    List<Integer> removeOddNums(int[] nums);
}
