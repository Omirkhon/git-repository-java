package functional_style.task2;

import java.util.List;

public class CandyBox {
    final String boxTitle;
    final List<Candy> candies;
    final long numberOfCandies;

    public CandyBox(String boxTitle, List<Candy> candies) {
        this.boxTitle = boxTitle;
        this.candies = candies;
        numberOfCandies = candies.size();
    }

    private static final List<String> prohibitedProducers = List.of("Рахат");

    public static boolean isProducerAllowed(Candy candy) {
        if (!prohibitedProducers.contains(candy.name))
            return true;
        else
            return false;
    }

    public void printContent() {
        System.out.println("Набор " + boxTitle
                + ", содержит " + numberOfCandies + " конфет");
        candies.forEach(candy ->
                System.out.println(candy.name + " производства " + candy.producer + ", цена: " + candy.price));
    }
}
