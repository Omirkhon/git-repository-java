package jdbc.homework.task1;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:postgresql://localhost:5432/products";
        String username = "postgres";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("1. Процессоры \n" +
                "2. Мониторы \n" +
                "Выберите категорию:");
        int choice = scanner.nextInt();

        PreparedStatement preparedStatement = connection.prepareStatement("select name, price from products where category_id = ?");
        preparedStatement.setInt(1, choice);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            int price = rs.getInt("price");
            System.out.println("- " + name + " (" + price + ")");
        }
    }
}
