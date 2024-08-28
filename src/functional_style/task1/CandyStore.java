package functional_style.task1;

import java.util.Arrays;
import java.util.Set;

public class CandyStore {
    public static void main(String[] args) {
        Candy candy1 = new Candy("Рахат", "Рахат", 140, 4, Set.of("Рафаэлло", "Қарақұм"));
        Candy candy2 = new Candy("Шокобар", "Баян Сұлу", 160, 2, Set.of("Шоко", "Баян"));
        Candy candy3 = new Candy("Ақ Тілегім", "Рахат", 220, 5, Set.of("Ақ тілегім", "Ақ тілек"));
        Candy candy4 = new Candy("Тайжану", "Баян Сұлу", 70, 12, Set.of("ТАЙЖАНУ"));

        Candy[] candies = {candy1, candy2, candy3, candy4};

        System.out.println("Сортировка по имени");
        Arrays.sort(candies, Candy::compareByName);
        Arrays.stream(candies).forEach(Candy::printNameWithPrice);

        System.out.println("Сортировка по цене");
        Arrays.sort(candies, Candy::compareByPrice);
        Arrays.stream(candies).forEach(Candy::printNameWithPrice);
    }
}
