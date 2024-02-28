package org.example;

import java.io.File;

public class DeleteFile {
    public void deleteFile() {
        String filePath = System.getProperty("user.dir") + "/src/main/files/kopidlno.xml";
        File file = new File(filePath);
        try {
            file.delete();
            System.out.println("Soubor smazán");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
