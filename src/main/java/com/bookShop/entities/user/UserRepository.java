package com.bookShop.entities.user;

import java.util.List;

/**
 *
 * @author Hakim
 */
public interface UserRepository {
    int saveUser(UserDTO dto);
    int updateUser(UpdateDTO dto,int userId);
    int deleteUser(int userId);
    User getUser(int id);
    User getUser(String email);
    List<User> getAllUsers();
    int numOfNumbers();
    User getAdmin();
    User login(LoginDTO dto);
    int changePassword(int userId,String password);
}
