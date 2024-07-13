package ArrayListTask4;

import java.util.Comparator;

public class NewComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer element1, Integer element2) {
        return element2 - element1;
    }
}
