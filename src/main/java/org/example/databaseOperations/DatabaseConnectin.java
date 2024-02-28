package org.example.databaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectin {

    public Connection createConnection(Connection conn) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Připojování k databázi");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");
            System.out.println("Připojen k databázi");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Odpojen od databáze");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
