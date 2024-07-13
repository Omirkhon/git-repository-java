package ArrayListTask3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
        findCommonNums(list1, list2);
    }

    public static void findCommonNums(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> list3 = new ArrayList<>();
        for (Integer num1 : list1) {
            if(list3.contains(num1)) {
                list3.remove(num1);
            } else if (list2.contains(num1)) {
                list3.add(num1);
            }
        }
        System.out.println(list3);
    }
}
