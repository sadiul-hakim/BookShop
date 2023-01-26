package com.bookShop.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Hakim
 */
public class FileUploader {

    private static final Logger logger = LoggerFactory.getLogger(FileUploader.class);
    
    public static boolean delete(String fullPath){
        boolean isSaved=false;
        try{
            File file=new File(fullPath);
            if(file.exists()){
                file.delete();
            }
            isSaved=true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return isSaved;
    }

    public static boolean upload(InputStream is, String path) {
        boolean isSaved = false;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (OutputStream os = new FileOutputStream(file)) {

                byte[] bytes = new byte[is.available()];
                is.read(bytes);

                os.write(bytes);
                os.flush();
                isSaved = true;
            }
        } catch (FileNotFoundException ex) {
            logger.error("Could not upload File.");
            ex.printStackTrace();
        } catch (IOException ex) {
            logger.error("Could not upload File.");
            ex.printStackTrace();
        }
        return isSaved;
    }
}
