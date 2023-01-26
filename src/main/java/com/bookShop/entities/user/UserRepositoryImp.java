package com.bookShop.entities.user;

import com.bookShop.helper.Encryptor;
import java.sql.Connection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bookShop.helper.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hakim
 */
public class UserRepositoryImp implements UserRepository {

    private Encryptor encryptor;
    private final Logger logger = LoggerFactory.getLogger(UserRepositoryImp.class);

    public UserRepositoryImp() {

    }

    public UserRepositoryImp(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

    @Override
    public int saveUser(UserDTO dto) {
        int result = -1;

        User user = getUser(dto.getEmail());
        if (user != null) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("User already registered.Please login!");
            return result;
        }

        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "insert into user(name,email,phone,password,role,photo) values(?,?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                String password = dto.getPassword();
                dto.setPassword(encryptor.encrypt(password));

                statement.setString(1, dto.getName());
                statement.setString(2, dto.getEmail());
                statement.setString(3, dto.getPhone());
                statement.setString(4, dto.getPassword());
                statement.setString(5, "user");
                statement.setString(6, "default.png");

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not register user.Please try again!");
            logger.error("Could not save user.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public int updateUser(UpdateDTO dto, int userId) {
        int result = -1;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "update user set name=?,photo=? where id=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                statement.setString(1, dto.getName());
                statement.setString(2, dto.getPhoto());
                statement.setInt(3, userId);

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not Update user.Please try again!");
            logger.error("Could not Update user.Error : " + ex.getMessage());
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public int deleteUser(int userId) {
        int result = -1;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "delete from user where id=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, userId);

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not delete user.Please try again!");
            logger.error("Could not Delete user.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public User getUser(int id) {
        User user = null;
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from user where id = ?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, id);

                set = statement.executeQuery();

                if (set.next()) {
                    user = new User(
                            set.getInt("id"),
                            set.getString("name"),
                            set.getString("email"),
                            set.getString("phone"),
                            set.getString("photo"),
                            set.getString("role"),
                            set.getString("password"),
                            set.getTimestamp("joinedAt")
                    );
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get user.Please try again!");
            logger.error("Could not get user.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return user;
    }

    @Override
    public User getUser(String email) {
        User user = null;
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from user where email = ?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setString(1, email);

                set = statement.executeQuery();

                if (set.next()) {
                    user = new User(
                            set.getInt("id"),
                            set.getString("name"),
                            set.getString("email"),
                            set.getString("phone"),
                            set.getString("photo"),
                            set.getString("role"),
                            set.getString("password"),
                            set.getTimestamp("joinedAt")
                    );
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get user.Please try again!");
            logger.error("Could not get user.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from user where role='user'";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                set = statement.executeQuery();

                while (set.next()) {
                    users.add(new User(
                            set.getInt("id"),
                            set.getString("name"),
                            set.getString("email"),
                            set.getString("phone"),
                            set.getString("photo"),
                            set.getString("role"),
                            set.getString("password"),
                            set.getTimestamp("joinedAt")
                    ));
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get all user.Please try again!");
            logger.error("Could not get all user.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return users;
    }

    @Override
    public int numOfNumbers() {
        int num = -1;
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select count(id) as num from user";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                set = statement.executeQuery();

                if (set.next()) {
                    num = set.getInt("num");
                }

            }
        } catch (SQLException ex) {
            logger.error("Could not get num of user.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }
        return num;
    }

    @Override
    public User getAdmin() {
        User user = null;
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from user where role = 'admin'";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                set = statement.executeQuery();

                if (set.next()) {
                    user = new User(
                            set.getInt("id"),
                            set.getString("name"),
                            set.getString("email"),
                            set.getString("phone"),
                            set.getString("photo"),
                            set.getString("role"),
                            set.getString("password"),
                            set.getTimestamp("joinedAt")
                    );
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get admin.Please try again!");
            logger.error("Could not get admin.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return user;
    }

    @Override
    public User login(LoginDTO dto) {
        String password = dto.getPassword();
        dto.setPassword(encryptor.encrypt(password));
        User user = getUser(dto.getEmail());
        if (user == null) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Invalid Credentials.Please try again!");
            return user;
        } else if (!user.getPassword().equals(dto.getPassword())) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Invalid Credentials.Please try again!");
            return null;
        }
        return user;
    }

    @Override
    public int changePassword(int userId, String password) {
        int result = -1;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "update user set password=? where id=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                statement.setString(1, password);
                statement.setInt(2, userId);

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not Update user.Please try again!");
            logger.error("Could not Update user.Error : " + ex.getMessage());
            ex.printStackTrace();
        }

        return result;
    }

}
