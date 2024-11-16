package jdbc.app.dao;

import jdbc.app.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdbc.app.utils.ConnectionFactory.getConnection;

public class CategoryDao {
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from categories")
        ) {
            while (resultSet.next()) {
                Category category = makeCategory(resultSet);
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }

    public Category findById(long id) {
        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement("select * from categories where id = ?")
        ) {
            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return makeCategory(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Category createCategory(Category category) {
        try (
                Connection connection = getConnection()
        ) {
            String sql = "insert into categories(name) values(?)";
            var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            try (preparedStatement) {
                preparedStatement.setString(1, category.getName());
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        long id = rs.getLong("id");
                        category.setId(id);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    private Category makeCategory(ResultSet resultSet) throws SQLException {
        return new Category(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );
    }
}
