package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookManagement {

    public static void addBook(String title, String author, String role) {
        if (!"LIBRARIAN".equals(role)) {
            System.out.println("Access denied. Only librarians can add books.");
            return;
        }

        String sql = "INSERT INTO Books(title, author) "
                + "VALUES('" + title + "', '" + author + "')";

        try (Connection conn = LibraryDatabase.connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Book added successfully: " + title + " by " + author);
        } catch (SQLException e) {
            System.out.println("Failed to add book: " + e.getMessage());
        }
    }

    public static void viewAvailableBooks() {
        String sql = "SELECT * FROM Books";

        try (Connection conn = LibraryDatabase.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Times Read: " + rs.getInt("readCount"));
                System.out.println("--------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve books: " + e.getMessage());
        }
    }

    public static void recommendBook() {
        String sql = "SELECT * FROM Books ORDER BY readCount DESC LIMIT 1";

        try (Connection conn = LibraryDatabase.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("Recommended Book:");
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Times Read: " + rs.getInt("readCount"));
            } else {
                System.out.println("No books available to recommend.");
            }
        } catch (SQLException e) {
            System.out.println("Recommendation failed: " + e.getMessage());
        }
    }

    public static void markBookAsRead(int bookId) {
        String sql = "UPDATE Books SET readCount = readCount + 1 WHERE id = " + bookId;

        try (Connection conn = LibraryDatabase.connect();
             Statement stmt = conn.createStatement()) {
            int rowsUpdated = stmt.executeUpdate(sql);
            if (rowsUpdated > 0) {
                System.out.println("Book marked as read successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to mark book as read: " + e.getMessage());
        }
    }
}
