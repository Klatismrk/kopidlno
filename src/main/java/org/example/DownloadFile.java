package org.example;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DownloadFile {
    public void downloadFile() {
        String downloadUrl = "https://www.smartform.cz/download/kopidlno.xml.zip";
        String projectDir = System.getProperty("user.dir");
        String downloadDir = projectDir + "/src/main/files/";

        try {
            URL url = new URL(downloadUrl);
            InputStream inputStream = url.openStream();
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            ZipEntry entry = zipInputStream.getNextEntry();
            while (entry != null) {
                String fileName = "kopidlno.xml";
                Files.copy(zipInputStream, Paths.get(downloadDir + fileName));
                zipInputStream.closeEntry();
                entry = zipInputStream.getNextEntry();
            }
            zipInputStream.close();
            inputStream.close();
            System.out.println("Staženo a odzipováno");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
