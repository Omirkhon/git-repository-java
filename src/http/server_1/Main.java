package http.server_1;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    private static final int PORT = 8080;

    // IOException могут сгенерировать методы create() и bind(...)
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();

        httpServer.bind(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler());
        // добавьте новый обработчик для /day тут
        httpServer.createContext("/day", new RandomDayOfWeekHandler());
        httpServer.createContext("/calculate", new NumbersHandler());
        httpServer.start(); // запускаем сервер

        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
    }
}
