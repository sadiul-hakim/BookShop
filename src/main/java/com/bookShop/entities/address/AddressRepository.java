package com.bookShop.entities.address;

import java.util.List;

/**
 *
 * @author Hakim
 */
public interface AddressRepository {
    int save(AddressDTO dto);
    int update(AddressDTO dto,int id);
    int delete(int id);
    int deleteByUserId(int id);
    List<Address> getAllAddresses();
    List<Address> getAllAddressesOfUser(int userId);
    Address getAddress(int userId);
}
