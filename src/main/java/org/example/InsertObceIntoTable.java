package org.example;

import java.sql.*;
import java.util.List;

public class InsertObceIntoTable {

    public void insertObceIntoTable(List<Obec> listObce) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Připojování k databázy");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "pass");
            System.out.println("Pripojen k databázy");

            String sql = "INSERT INTO obec (kod, nazev) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);

            for(Obec obec : listObce) {
                Integer kod = obec.getKod();
                String nazev = obec.getNazev();
                stmt.setInt(1, kod);
                stmt.setString(2, nazev);
                stmt.executeUpdate();
                System.out.println("Do tabulky obec přidáno: " + nazev);
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
