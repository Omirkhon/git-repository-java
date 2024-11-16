package jdbc.app.dao;

import jdbc.app.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdbc.app.utils.ConnectionFactory.getConnection;

public class ProductDao {
    private final CategoryDao categoryDao = new CategoryDao();
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from products")
        ) {
            while (resultSet.next()) {
                Product product = makeProduct(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public Product findById(int id) {
        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement("select * from products where id = ?")
        ) {
            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return makeProduct(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Product createProduct(Product product) {
        try (
                Connection connection = getConnection()
        ) {
            String sql = "insert into products(name, price, category_id) values(?, ?, ?)";
            var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            try (preparedStatement) {
                preparedStatement.setString(1, product.getName());
                preparedStatement.setLong(2, product.getPrice());
                preparedStatement.setLong(3, product.getCategory().getId());
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        long id = rs.getLong("id");
                        product.setId(id);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    public Product updateProduct(Product product) {
        try (
                Connection connection = getConnection()
        ) {
            String sql = "update products set name = ?, price = ?, category_id = ? where id = ?";
            var preparedStatement = connection.prepareStatement(sql);
            try (preparedStatement) {
                preparedStatement.setString(1, product.getName());
                preparedStatement.setLong(2, product.getPrice());
                preparedStatement.setLong(3, product.getCategory().getId());
                preparedStatement.setLong(4, product.getId());
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        long id = rs.getLong("id");
                        product.setId(id);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    public void deleteProduct(long id) {
        try (
                Connection connection = getConnection()
        ) {
            String sql = "delete from products where id = ?";
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Product makeProduct(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getInt("price"),
                categoryDao.findById(resultSet.getInt("category_id"))
        );
    }
}
