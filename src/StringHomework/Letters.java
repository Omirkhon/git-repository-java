package StringHomework;

import java.util.LinkedHashMap;
import java.util.Map;

public class Letters {
    public static Map<Character, Integer> letters = new LinkedHashMap<>();

    public static void main(String[] args) {
        String text = "Программирование на Java";
        findNumOfLetters(text);
    }

    public static void findNumOfLetters(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            if (!sentence.substring(i, i+1).isBlank()) {
                if (!letters.containsKey(sentence.charAt(i)))
                    letters.put(sentence.charAt(i), 1);
                else
                    letters.put(sentence.charAt(i), letters.get(sentence.charAt(i)) + 1);
            }
        }
        System.out.println(letters);
    }
}
