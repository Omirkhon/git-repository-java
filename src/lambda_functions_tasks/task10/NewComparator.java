package lambda_functions_tasks.task10;

import java.util.Comparator;

public class NewComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
