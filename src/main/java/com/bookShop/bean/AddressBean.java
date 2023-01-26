package com.bookShop.bean;

import com.bookShop.entities.address.Address;
import com.bookShop.entities.address.AddressRepository;
import com.bookShop.entities.address.AddressRepositoryImp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hakim
 */
public class AddressBean {
    private final AddressRepository repository=new AddressRepositoryImp();
    private int userId;
    private List<Address> addressListOfUser=new ArrayList<>();
    private List<Address> addressList=new ArrayList<>();

    public List<Address> getAddressList() {
        addressList=repository.getAllAddresses();
        return addressList;
    }
    
    public List<Address> getAddressListOfUser() {
        addressListOfUser=repository.getAllAddressesOfUser(userId);
        return addressListOfUser;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
