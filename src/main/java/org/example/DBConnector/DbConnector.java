package org.example.DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    public static Connection getConnection() {
        try {
            String dbUrl = System.getenv("DB_URL");
            String dbUsername = System.getenv("DB_USERNAME");
            String dbPassword = System.getenv("DB_PASSWORD");

            return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
    }
}
