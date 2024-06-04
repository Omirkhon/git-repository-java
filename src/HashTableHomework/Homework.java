package HashTableHomework;

import java.util.HashMap;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        HashMap<String, Double> currencies = new HashMap<>();

        currencies.put("USD", 441.58);
        currencies.put("EUR", 476.46);
        currencies.put("JPY", 2.82);

        System.out.print("Введите сумму в тенге: ");
        Scanner scanner = new Scanner(System.in);
        double tenges = scanner.nextInt();
        System.out.println("Выберите валюту: ");
        for (String currency : currencies.keySet()){
            System.out.println(currency);
        }
        String currency = scanner.next();
        boolean isCurrency = false;
        for(double value : currencies.values()){
            if (currencies.containsKey(currency)) {
                isCurrency = true;
                value = tenges / currencies.get(currency);
                System.out.println(tenges+" тг. "+" в "+currency+" составляет "+value);
                break;
            }
        }
        if (!isCurrency) {
            System.out.println("Такой валюты нет в списке.");
        }
    }
}
