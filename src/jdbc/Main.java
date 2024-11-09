package jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/products";
        String username = "postgres";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select name, price from products");

        String maxPriceProductName = null;
        int maxPriceProductPrice = 0;

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            if (price > maxPriceProductPrice) {
                maxPriceProductPrice = price;
                maxPriceProductName = name;
            }
            System.out.println("Название: " + name + "\n" + "Стоимость: " + price + "\n");
        }

        System.out.println("Самый дорогой товар: " + maxPriceProductName + " (" + maxPriceProductPrice + ")");
    }
}
