package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    public void createTables() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Připojování k databázy");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");
            System.out.println("Pripojen k databázy");
            stmt = conn.createStatement();

            String sql = "DROP TABLE IF EXISTS \"cast_obce\";\n" +
                    "DROP TABLE IF EXISTS \"obec\";\n" +
                    "CREATE TABLE \"obec\" (\"kod\" int, \"nazev\" text, CONSTRAINT \"obec_pkey\" PRIMARY KEY (\"kod\"));\n" +
                    "CREATE TABLE \"cast_obce\" (\"kod\" int, \"nazev\" text, \"kod_obec\" int REFERENCES \"obec\" (\"kod\"), CONSTRAINT \"cast_obce_pkey\" PRIMARY KEY (\"kod\"));";
            stmt.executeUpdate(sql);
            System.out.println("Tabulky vytvořeny");
        }catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null) {
                    conn.close();
                }
            }catch (SQLException se) {
            }
            try {
                if(conn != null) {
                    conn.close();
                }
            }catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
