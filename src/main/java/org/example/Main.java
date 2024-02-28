package org.example;

import org.example.databaseOperations.FillDatabase;
import org.example.entity.Village;
import org.example.entity.VillagePart;
import org.example.fileOperations.DeleteFile;
import org.example.fileOperations.DownloadFile;
import org.example.parseXml.CreateDocumentFromXml;
import org.example.parseXml.ReadFromDocument;
import org.w3c.dom.Document;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.smartform.cz/download/kopidlno.xml.zip";
        String fileName = "kopidlno.xml";

        DownloadFile downloadFile = new DownloadFile();
        CreateDocumentFromXml createDocumentFromXml = new CreateDocumentFromXml();
        ReadFromDocument readFromDocument = new ReadFromDocument();
        FillDatabase fillDatabase = new FillDatabase();
        DeleteFile deleteFile = new DeleteFile();

        downloadFile.downloadAndUnzipFile(url, fileName);
        Document document = createDocumentFromXml.createDocumentFromXml(fileName);
        List<Village> listVillages = readFromDocument.readVillagesFromDocument(document);
        List<VillagePart> listVillagesParts = readFromDocument.readVillagesPartsFromDocument(document);
        fillDatabase.fillKopidlnoDatabase(listVillages, listVillagesParts);
        deleteFile.deleteFile(fileName);
    }
}