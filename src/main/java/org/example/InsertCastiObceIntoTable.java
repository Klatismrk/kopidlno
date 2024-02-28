package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertCastiObceIntoTable {
    public void insertCastiObceIntoTable(List<CastObce> listCastiObce) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Připojování k databázy");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");
            System.out.println("Pripojen k databázy");

            String sql = "INSERT INTO cast_obce (kod, nazev, kod_obec) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            for(CastObce castObce : listCastiObce) {
                Integer kod = castObce.getKod();
                String nazev = castObce.getNazev();
                Integer kodObec = castObce.getKodObec();
                stmt.setInt(1, kod);
                stmt.setString(2, nazev);
                stmt.setInt(3, kodObec);
                stmt.executeUpdate();
                System.out.println("Do tabulky castObce přidáno: " + nazev);
            }
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
