package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Obec> listObci = new ArrayList<>();
        List<CastObce> listCastiObce = new ArrayList<>();

        CreateTables createTables = new CreateTables();
        DownloadFile downloadFile = new DownloadFile();
        DeleteFile deleteFile = new DeleteFile();
        ReadObecFromXml readObecFromXml = new ReadObecFromXml();
        ReadCastObceFromXml readCastObceFromXml = new ReadCastObceFromXml();
        InsertObceIntoTable insertObceIntoTable = new InsertObceIntoTable();
        InsertCastiObceIntoTable insertCastiObceIntoTable = new InsertCastiObceIntoTable();

        createTables.createTables();
        downloadFile.downloadFile();
        listObci = readObecFromXml.readObecFromXml();
        listCastiObce = readCastObceFromXml.readCastObceFromXml();
        insertObceIntoTable.insertObceIntoTable(listObci);
        insertCastiObceIntoTable.insertCastiObceIntoTable(listCastiObce);


        deleteFile.deleteFile();
    }
}