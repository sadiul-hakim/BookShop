package com.bookShop.helper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Hakim
 */
public class Sha256Encryptor implements Encryptor {
    private final Logger logger=LoggerFactory.getLogger(Sha256Encryptor.class);
    @Override
    public String encrypt(String msg) {
        String hash=null;
        try{
            var digest =MessageDigest.getInstance("SHA-256");
            var bytes=digest.digest(msg.getBytes(StandardCharsets.UTF_8));
            hash= bytesToHex(bytes);
        }catch(NoSuchAlgorithmException ex){
            logger.error("Could not hash msg.Error : "+ex.getMessage());
        }
        return hash;
    }
    
    private String bytesToHex(byte[] bytes){
        StringBuilder sb=new StringBuilder();
        for(byte b:bytes){
            String hex=Integer.toHexString(0xff & b);
            if(hex.length()==1){
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
    
}
