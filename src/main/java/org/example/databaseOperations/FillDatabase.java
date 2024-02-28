package org.example.databaseOperations;

import org.example.entity.Village;
import org.example.entity.VillagePart;

import java.sql.Connection;
import java.util.List;

public class FillDatabase {

    private Connection conn = null;

    public void fillKopidlnoDatabase(List<Village> listVillages, List<VillagePart> listVillagesParts) {
        DatabaseConnectin dbConn = new DatabaseConnectin();
        CreateTables createTables = new CreateTables();
        InsertTables insertTables = new InsertTables();
        conn = dbConn.createConnection(conn);
        createTables.createTables(conn);
        insertTables.insertVillagesIntoTable(listVillages, conn);
        insertTables.insertVillagesPartsIntoTable(listVillagesParts, conn);
        dbConn.closeConnection(conn);
    }
}
