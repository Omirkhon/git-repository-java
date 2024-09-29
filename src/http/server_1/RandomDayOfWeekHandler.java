package http.server_1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class RandomDayOfWeekHandler implements HttpHandler {
    private final String[] daysOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("Началась обработка /day запроса от клиента.");

        Random random = new Random();
        int randomNumber = random.nextInt(daysOfWeek.length);
        httpExchange.sendResponseHeaders(200, 0);

        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(daysOfWeek[randomNumber].getBytes());
        }
    }
}
