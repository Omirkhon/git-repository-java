package Shop;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> sales1 = new HashMap<>();
        sales1.put("Товар A", 10);
        sales1.put("Товар B", 5);
        sales1.put("Товар C", 8);

        HashMap<String, Integer> sales2 = new HashMap<>();
        sales2.put("Товар B", 3);
        sales2.put("Товар D", 7);
        sales2.put("Товар E", 2);

        System.out.println(uniteSales(sales1, sales2));
    }

    public static HashMap<String, Integer> uniteSales(HashMap<String, Integer> sales1, HashMap<String, Integer> sales2) {
        HashMap<String, Integer> totalSales = new HashMap<>();
        for (String sale : sales1.keySet()) {
            totalSales.put(sale, sales1.get(sale));
        }
        for (String sale : sales2.keySet()) {
            if (totalSales.containsKey(sale)) {
                totalSales.put(sale, sales2.get(sale)+totalSales.get(sale));
            } else {
                totalSales.put(sale, sales2.get(sale));
            }
        }
        return totalSales;
    }
}
