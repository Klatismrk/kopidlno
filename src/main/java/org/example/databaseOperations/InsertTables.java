package org.example.databaseOperations;

import org.example.entity.Village;
import org.example.entity.VillagePart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertTables {

    public void insertVillagesIntoTable(List<Village> listVillages, Connection conn) {

        try {
            String sql = "INSERT INTO village (code, name) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            for(Village village : listVillages) {
                Integer code = village.getCode();
                String name = village.getName();
                stmt.setInt(1, code);
                stmt.setString(2, name);
                stmt.executeUpdate();
                System.out.println("Do tabulky village přidáno: " + name);
            }
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void insertVillagesPartsIntoTable(List<VillagePart> listVillagesParts, Connection conn) {

        try {
            String sql = "INSERT INTO village_part (code, name, village_code) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            for(VillagePart villagePart : listVillagesParts) {
                Integer code = villagePart.getCode();
                String name = villagePart.getName();
                Integer villageCode = villagePart.getVillageCode();
                stmt.setInt(1, code);
                stmt.setString(2, name);
                stmt.setInt(3, villageCode);
                stmt.executeUpdate();
                System.out.println("Do tabulky village_part přidáno: " + name);
            }
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
