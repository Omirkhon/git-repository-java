package lambda_functions_tasks.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("барабаны");
        words.add("гвоздь");
        words.add("стол");
        words.add("гитара");
        words.add("дождь");

        Lambda lambda = (letter, strings) -> {
            List<String> sortedStr = new ArrayList<>();
            for (String str : strings) {
                if (str.startsWith(letter)) {
                    sortedStr.add(str);
                }
            }
            return sortedStr;
        };
        System.out.println(lambda.findWordsStartingWith("г", words));
    }
}

interface Lambda {
    List<String> findWordsStartingWith(String letter, List<String> strings);
}
