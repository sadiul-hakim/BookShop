package com.bookShop.bean;

import com.bookShop.entities.user.User;
import com.bookShop.helper.PathLocator;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Hakim
 */
public class PathBean {
    private HttpServletRequest request;
    private User user;
    private String userPic;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getUserPic() {
        userPic=PathLocator.getUserPicPath(request, user);
        return userPic;
    }
    
    
}
