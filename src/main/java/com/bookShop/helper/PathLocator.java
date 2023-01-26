package com.bookShop.helper;

import com.bookShop.entities.user.User;
import jakarta.servlet.http.HttpServletRequest;
import java.io.File;

/**
 *
 * @author Hakim
 */
public class PathLocator {
    
    public static String getUserPicPath(HttpServletRequest request,User user){
        //getting root folder(img) path
        String root=request.getServletContext().getRealPath("img");
        //demonstrating complete path
        String demo=root+File.separator+"upload"+File.separator+"user"+File.separator+"user_"+user.getId();
        //folder path from img folder
        String folderPath="img"+File.separator+"upload"+File.separator+"user"+File.separator+"user_"+user.getId();
        File file=new File(demo);
        //empty vars
        String filePath="";
        String demoFile="";
        //check if folder exists
        if(file.exists()){
            //working file path
            filePath=folderPath+File.separator+user.getPhoto();
            //demo file path from root
            demoFile=demo+File.separator+user.getPhoto();
            
            if(new File(demoFile).exists()){
                System.out.println("file exists");
                return filePath;
            }else{
                filePath="img"+File.separator+"upload"+File.separator+"user"+File.separator+"default.png";
            }
        }else{
            filePath="img"+File.separator+"upload"+File.separator+"user"+File.separator+"default.png";
        }
        //return real file path
        return filePath;
    }
    public static String getUserPicUploadPath(HttpServletRequest request,int id,String picName){
        String root=request.getServletContext().getRealPath("img");
        String folderPath=root+File.separator+"upload"+File.separator+"user"+File.separator+"user_"+id;
        File file=new File(folderPath);
        
        if(!file.exists()){
            file.mkdir();
        }
        
        String filePath=folderPath+File.separator+picName;
        return filePath;
        
    }
    public static String getBookPicPath(HttpServletRequest request,String picName){
        return "img"+File.separator+"upload"+File.separator+"book"+File.separator+picName;
    }
    public static String getOldBookPicPath(HttpServletRequest request,String picName){
        return "img"+File.separator+"upload"+File.separator+"oldBook"+File.separator+picName;
    }
    public static String getOldBookPicUploadPath(HttpServletRequest request,String picName){
        String root=request.getServletContext().getRealPath("img");
        String folderPath=root+File.separator+"upload"+File.separator+"oldBook";
        File file=new File(folderPath);
        
        if(!file.exists()){
            file.mkdir();
        }
        
        String filePath=folderPath+File.separator+picName;
        return filePath;
    }
    public static String getBookPicUploadPath(HttpServletRequest request,String picName){
        String root=request.getServletContext().getRealPath("img");
        String folderPath=root+File.separator+"upload"+File.separator+"book";
        File file=new File(folderPath);
        
        if(!file.exists()){
            file.mkdir();
        }
        
        String filePath=folderPath+File.separator+picName;
        return filePath;
    }
}
