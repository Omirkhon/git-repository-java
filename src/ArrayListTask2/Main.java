package ArrayListTask2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "orange", "grape"));
        char letter = 'a';
        wordCheck(words, letter);
    }

    public static void wordCheck(ArrayList<String> words, char letter) {
        ArrayList<String> newWords = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith(Character.toString(letter))) {
                newWords.add(word);
            }
        }
        System.out.println(newWords);
    }
}
