package com.bookShop.entities.address;

import com.bookShop.entities.user.UserRepositoryImp;
import com.bookShop.helper.ConnectionProvider;
import com.bookShop.helper.ErrorMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Hakim
 */
public class AddressRepositoryImp implements AddressRepository {

    private final Logger logger = LoggerFactory.getLogger(UserRepositoryImp.class);

    public AddressRepositoryImp() {
    }

    @Override
    public int save(AddressDTO dto) {
        int result = -1;

        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "insert into address(userId,division,district,subdistrict,unionname,zip,address) values(?,?,?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                statement.setInt(1, dto.getUserId());
                statement.setString(2, dto.getDivision());
                statement.setString(3, dto.getDistrict());
                statement.setString(4, dto.getSubdistrict());
                statement.setString(5, dto.getUnionname());
                statement.setInt(6, dto.getZip());
                statement.setString(7, dto.getAddress());

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not save address.Please try again!");
            logger.error("Could not save address.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public int update(AddressDTO dto, int id) {
        int result = -1;

        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "update address set division=?,district=?,subdistrict=?,unionname=?,zip=?,address=? where userId=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                statement.setString(1, dto.getDivision());
                statement.setString(2, dto.getDistrict());
                statement.setString(3, dto.getSubdistrict());
                statement.setString(4, dto.getUnionname());
                statement.setInt(5, dto.getZip());
                statement.setString(6, dto.getAddress());
                statement.setInt(7, dto.getUserId());

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not update address.Please try again!");
            logger.error("Could not update address.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public int delete(int id) {
        int result = -1;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "delete from address where id=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, id);

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not delete address.Please try again!");
            logger.error("Could not Delete address.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public int deleteByUserId(int userId) {
        int result = -1;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "delete from address where userId=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, userId);

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not delete address.Please try again!");
            logger.error("Could not Delete address.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public List<Address> getAllAddresses() {
        List<Address> addresses = new ArrayList<>();
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from address";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                set = statement.executeQuery();

                while (set.next()) {
                    addresses.add(new Address(
                            set.getInt("id"),
                            set.getInt("userId"),
                            set.getString("division"),
                            set.getString("district"),
                            set.getString("subdistrict"),
                            set.getString("unionname"),
                            set.getInt("zip"),
                            set.getString("address"),
                            set.getTimestamp("addedAt"))
                    );
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get address.Please try again!");
            logger.error("Could not get address.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return addresses;
    }

    @Override
    public Address getAddress(int userId) {
        Address address = null;
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from address where userId = ?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, userId);

                set = statement.executeQuery();

                if (set.next()) {
                    address = new Address(
                            set.getInt("id"),
                            set.getInt("userId"),
                            set.getString("division"),
                            set.getString("district"),
                            set.getString("subdistrict"),
                            set.getString("unionname"),
                            set.getInt("zip"),
                            set.getString("address"),
                            set.getTimestamp("addedAt")
                    );
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get address.Please try again!");
            logger.error("Could not get address.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return address;
    }

    @Override
    public List<Address> getAllAddressesOfUser(int userId) {
        List<Address> addresses = new ArrayList<>();
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from address where userId=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1,userId);
                set = statement.executeQuery();

                while (set.next()) {
                    addresses.add(new Address(
                            set.getInt("id"),
                            set.getInt("userId"),
                            set.getString("division"),
                            set.getString("district"),
                            set.getString("subdistrict"),
                            set.getString("unionname"),
                            set.getInt("zip"),
                            set.getString("address"),
                            set.getTimestamp("addedAt"))
                    );
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get address.Please try again!");
            logger.error("Could not get address.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return addresses;
    }

}
