package org.example.fileOperations;

import java.io.File;

public class DeleteFile {
    public void deleteFile(String filename) {
        String filePath = System.getProperty("user.dir") + "/src/main/files/" + filename;
        File file = new File(filePath);
        try {
            file.delete();
            System.out.println("Soubor smazán");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
