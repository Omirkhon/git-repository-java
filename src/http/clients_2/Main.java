package http.clients_2;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static List<String> currencies = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        currencies.add("USD");
        currencies.add("EUR");
        currencies.add("RUB");

        while (true) {
            printMenu();
            int choice = SCANNER.nextInt();
            switch (choice) {
                case 1:
                    addCurrency();
                    break;
                case 2:
                    convert();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Введен некорректный запрос");
                    break;
            }
        }
    }

    public static void addCurrency() throws IOException, InterruptedException {
        System.out.print("Введите валюту (например: USD, EUR): ");
        String currency = SCANNER.next();

        if (URI(currency).statusCode() == 200) {
            currencies.add(currency);
        } else {
            System.out.println("Введена некорректная валюта");
        }
    }

    public static void convert() throws IOException, InterruptedException {
        System.out.print("Введите сумму в тг: ");
        int sum = SCANNER.nextInt();
        for (String currency : currencies) {
            System.out.println("- " + currency);
        }
        System.out.print("Выберите валюту: ");
        String currency = SCANNER.next();

        if (currencies.contains(currency)) {
            JsonElement jsonElement = JsonParser.parseString(URI(currency).body());
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonObject object = jsonObject.get("rates").getAsJsonObject();

            double currencyObject = object.get("KZT").getAsDouble();

            System.out.println(sum + " тг в " + currency + " составляет " + sum/currencyObject);
        } else {
            System.out.println("Введена некорректная валюта");
        }
    }

    public static HttpResponse<String> URI(String currency) throws IOException, InterruptedException {
        URI uri = URI.create("https://api.apilayer.com/exchangerates_data/latest?base="+currency+"&symbols=KZT&apikey=iISN69jOgAmSSuWq5GG68tko23CuqMLk");

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();

        HttpClient client = HttpClient.newHttpClient();

        return client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public static void printMenu() {
        System.out.print("1. Добавить валюту\n" +
                "2. Конвертировать\n" +
                "0. Выйти\n" +
                "Выберите действие: ");
    }
}
