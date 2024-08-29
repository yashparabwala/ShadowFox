package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManagement {

    public static void registerUser(String username, String password, String role) {
        String sql = "INSERT INTO Users(username, password, role) "
                + "VALUES('" + username + "', '" + password + "', '" + role + "')";

        try (Connection conn = LibraryDatabase.connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println(role + " registered successfully.");
        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    public static String loginUser(String username, String password) {
        String sql = "SELECT role FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
        String role = null;

        try (Connection conn = LibraryDatabase.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                role = rs.getString("role");
                System.out.println("Welcome back, " + username + "! You are logged in as " + role + ".");
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        return role;
    }
}
