package com.nctech.organicstore.config;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class DBConfig {
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/organic_store"; // Change to your database URL
    private final String username = "nctech";
    private final String password = "NCT@admin123";

    public Connection getConnection() throws SQLException {
        /* Load the MySQL JDBC driver not required since Java 1.6

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Loaded MySQL JDBC driver...");
        */

        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Connection established... ");
        return connection;
    }


}
