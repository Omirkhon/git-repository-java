package StringHomework;

public class FindRepeats {
    public static void main(String[] args) {
        int count = numberOfRepeats("раз, раз, раз", "раз");
        System.out.println("Количество повторений: "+count);
    }

    public static int numberOfRepeats(String text, String substring) {
        int count = 0;
        int length = substring.length();
        for (int i = 0; i<text.length(); i++) {
            if (text.startsWith(substring, i)) {
                count++;
            }
        }
        return count;
    }
}
