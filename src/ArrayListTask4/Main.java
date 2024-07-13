package ArrayListTask4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;
        ArrayList<Integer> nums = new ArrayList();
        for (int i = 0; i < size; i++) {
            nums.add(random.nextInt());
        }
        Collections.sort(nums, new NewComparator());
        System.out.println(nums);
    }
}

