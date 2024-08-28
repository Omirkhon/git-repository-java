package functional_style.task2;

import java.util.List;
import java.util.Set;

public class CandyBoxesStore {
    public static void main(String[] args) {
        Candy candy1 = new Candy("Рахат", "Рахат", 140, 4, Set.of("Рафаэлло", "Қарақұм"));
        Candy candy2 = new Candy("Шокобар", "Баян Сұлу", 160, 2, Set.of("Шоко", "Баян"));
        Candy candy3 = new Candy("Ақ Тілегім", "Рахат", 220, 5, Set.of("Ақ тілегім", "Ақ тілек"));
        Candy candy4 = new Candy("Тайжану", "Баян Сұлу", 70, 12, Set.of("ТАЙЖАНУ"));

        List<Candy> candies = List.of(candy1, candy2, candy3, candy4);

        List<Candy> candiesForBox = candies.stream()
                .filter(CandyBox::isProducerAllowed)
                .map(candy -> new Candy(candy.name, candy.producer, candy.price-5, candy.amountSold, candy.alternateNames))
                .sorted(Candy::compareByName).toList();

        CandyBox candyBox = new CandyBox("С Новым Годом", candiesForBox);

        candyBox.printContent();
    }
}
