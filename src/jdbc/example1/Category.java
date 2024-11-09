package jdbc.example1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Category {
    long id;
    String name;

    public Category (long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Category getById(long id, Connection connection) {
        try (PreparedStatement prepared = connection.prepareStatement("select * from categories where id = ?")) {
            prepared.setLong(1, id);

            try(var resultSet = prepared.executeQuery()) {
                if (resultSet.next()) {
                    return new Category(
                            resultSet.getLong("id"),
                            resultSet.getString("name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
