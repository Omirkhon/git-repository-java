package StringHomework;

public class NumOfWords {
    public static void main(String[] args) {
        String sentence = "Сегодня отличный день для программирования.";
        System.out.println("Количество слов в предложении: "+findNumberOfWords(sentence));
    }

    public static int findNumberOfWords (String sentence) {
        int count = 1;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.substring(i, i+1).isBlank()) {
                count++;
            } else if (sentence.isEmpty()) {
                return 0;
            }
        }
        return count;
    }
}
