package com.bookShop.helper;

/**
 *
 * @author Hakim
 */
public class ErrorMessage{
    private static StringBuilder msg=new StringBuilder();

    public static String getMsg() {
        return msg.toString();
    }

    public static void setMsg(String msg) {
        ErrorMessage.msg.append("<br/>").append(msg);
    }
    public static void clear(){
        ErrorMessage.msg=new StringBuilder();
    }
    
}
