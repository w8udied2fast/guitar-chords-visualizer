package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChordRepository {
    public static String[] findByName(String name) throws SQLException {
        String query = "SELECT strings FROM chords WHERE name = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String strings = resultSet.getString("strings");
                return strings.split(",");
            }
        }
        return null;
    }
}