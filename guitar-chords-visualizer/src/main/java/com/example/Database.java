package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:sqlite:chords.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}