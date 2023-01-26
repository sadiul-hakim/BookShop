package com.bookShop.helper;

import com.bookShop.entities.user.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Hakim
 */
public class SecurityContext {
    private static final String AUTH_KEY="user";
    
    public static void login(HttpServletRequest request,User user,HttpServletResponse response){
        HttpSession oldSession=request.getSession(false);
        if(oldSession!=null){
            oldSession.invalidate();
        }
        
        HttpSession session=request.getSession(true);
        session.setAttribute(AUTH_KEY, user);
        
        Cookie cookie=new Cookie("prof", "ok");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-30);
        response.addCookie(cookie);
        
    }
    public static void logout(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        session.removeAttribute(AUTH_KEY);
    }
}
