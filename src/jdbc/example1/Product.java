package jdbc.example1;

import java.sql.Connection;

public class Product {
    long id;
    String name;
    long price;
    Category category;

    public Product (long id, String name, long price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static void createProduct(Product product, Connection connection) {
        try {
            var preparedStatement = connection.prepareStatement("insert into products (id, name, price, category_id) values (?, ?, ?, ?)");

            preparedStatement.setLong(1, product.id);
            preparedStatement.setString(2, product.name);
            preparedStatement.setLong(3, product.price);
            preparedStatement.setLong(4, product.category.id);

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString () {
        return this.id + " " + this.name + " "
                + this.price + "$ " + this.category.id + " " + this.category.name;
    }
}
