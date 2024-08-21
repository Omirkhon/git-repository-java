package lambda_functions_tasks.task8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(3);
        nums.add(8);
        nums.add(-2);
        nums.add(4);

        Predicate<List<Integer>> isNegative = integers -> {
          for (int num : integers) {
              if (num<0) {
                  return true;
              }
          }
          return false;
        };
        System.out.println("Список содержит отрицательное число: "+isNegative.test(nums));
    }
}

