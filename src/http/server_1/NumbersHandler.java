package http.server_1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class NumbersHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();

        String[] params = query.split("&");
        String num1 = params[0].split("=")[1];
        String num2 = params[1].split("=")[1];

        exchange.sendResponseHeaders(200, 0);


        String response = num1 + " + " + num2 + " = " + (Integer.parseInt(num1)+Integer.parseInt(num2));

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
