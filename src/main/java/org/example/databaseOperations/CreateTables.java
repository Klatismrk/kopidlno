package org.example.databaseOperations;

import java.sql.*;

public class CreateTables {
    public void createTables(Connection conn) {
        try {
            String sql = "DROP TABLE IF EXISTS \"village_part\";\n" +
                    "DROP TABLE IF EXISTS \"village\";\n" +
                    "CREATE TABLE \"village\" (\"code\" int, \"name\" text, CONSTRAINT \"village_pkey\" PRIMARY KEY (\"code\"));\n" +
                    "CREATE TABLE \"village_part\" (\"code\" int, \"name\" text, \"village_code\" int REFERENCES \"village\" (\"code\"), CONSTRAINT \"village_part_pkey\" PRIMARY KEY (\"code\"));";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Tabulky vytvořeny");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
