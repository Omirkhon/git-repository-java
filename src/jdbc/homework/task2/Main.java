package jdbc.homework.task2;

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
                "Введите id категории (через запятую с пробелом):");

        String choice = scanner.nextLine();

        String[] split = choice.split(", ");

        PreparedStatement ps = connection.prepareStatement("select name, price from products where category_id in (?, ?)");
        ps.setInt(1, Integer.parseInt(split[0]));
        ps.setInt(2, Integer.parseInt(split[1]));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            int price = rs.getInt("price");
            System.out.println("- " + name + " (" + price + ")");
        }
    }
}
