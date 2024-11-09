package jdbc.example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<Product> products;

        String url = "jdbc:postgresql://localhost:5432/products";
        String username = "postgres";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);

        Product product = new Product(5, "Xiaomi Mi", 150, Category.getById(2, connection));
        Product.createProduct(product, connection);

        products = findAllProducts(connection);

        products.forEach(System.out::println);
    }

    static List<Product> findAllProducts(Connection connection) throws SQLException {
        List<Category> categories = findAllCategories(connection);
        List<Product> products = new ArrayList<>();
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery("select * from products join categories on products.category_id = categories.id");

        try (statement; resultSet) {
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getLong("price"),
                        categories.stream().filter(category -> {
                            try {
                                return category.id == resultSet.getLong("category_id");
                            } catch (SQLException e) {
                            }
                            return false;
                        }).findFirst().orElseThrow());
                products.add(product);
            }
        }
        return products;
    }

    static List<Category> findAllCategories(Connection connection) throws SQLException {
        List<Category> categories = new ArrayList<>();
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery("select * from categories");

        try (statement; resultSet) {
            while (resultSet.next()) {
                Category category = new Category(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );
                categories.add(category);
            }
        }
        return categories;
    }
}

