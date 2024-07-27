package StringHomework;

public class LongestWord {
    public static void main(String[] args) {
        String text = "Java удивительный язык программирования";
        System.out.println(findLongestWord(text));
    }

    public static String findLongestWord(String text) {
        String longestWord = "";
        String currentWord = "";
        for (int i = 0; i < text.length(); i++) {
            if (!text.substring(i, i+1).isBlank()) {
                currentWord += text.substring(i, i+1);
            } else {
                if (currentWord.length()>longestWord.length())
                    longestWord = currentWord;
                currentWord = "";
            }
        }
        if (currentWord.length()>longestWord.length())
            longestWord = currentWord;
        return longestWord;
    }
}
