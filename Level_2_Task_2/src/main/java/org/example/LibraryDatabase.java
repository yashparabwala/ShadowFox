package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryDatabase {

    private static final String URL = "jdbc:sqlite:librarySystem.db"; // Changed the database name for uniqueness

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connected to SQLite database.");
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn;
    }

    public static void createTables() {
        String usersTable = "CREATE TABLE IF NOT EXISTS Users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "username TEXT NOT NULL UNIQUE, "
                + "password TEXT NOT NULL, "
                + "role TEXT NOT NULL);";

        String booksTable = "CREATE TABLE IF NOT EXISTS Books ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title TEXT NOT NULL, "
                + "author TEXT NOT NULL, "
                + "readCount INTEGER NOT NULL DEFAULT 0);";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(usersTable);
            stmt.execute(booksTable);
            System.out.println("Tables setup completed.");
        } catch (SQLException e) {
            System.out.println("Table creation failed: " + e.getMessage());
        }
    }
}
