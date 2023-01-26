package com.bookShop.bean;

import com.bookShop.entities.user.User;
import com.bookShop.entities.user.UserRepository;
import com.bookShop.entities.user.UserRepositoryImp;
import java.util.List;

/**
 *
 * @author Hakim
 */
public class UserBean {
    private final UserRepository repository=new UserRepositoryImp();
    private List<User> allUsers;
    private int userId;
    private User user;

    public User getUser() {
        user=repository.getUser(userId);
        return user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    

    public List<User> getAllUsers() {
        allUsers=repository.getAllUsers();
        return allUsers;
    }
    
    
}
