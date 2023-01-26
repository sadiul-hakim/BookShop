package com.bookShop.entities.address;

import java.sql.Timestamp;

/**
 *
 * @author Hakim
 */
public class Address {
    private int id;
    private int userId;
    private String division;
    private String district;
    private String subdistrict;
    private String unionname;
    private int zip;
    private String address;
    private Timestamp addedAt;

    public Address() {
    }

    public Address(int id, int userId, String division, String district, String subdistrict, String unionname, int zip, String address, Timestamp addedAt) {
        this.id = id;
        this.userId = userId;
        this.division = division;
        this.district = district;
        this.subdistrict = subdistrict;
        this.unionname = unionname;
        this.zip = zip;
        this.address = address;
        this.addedAt = addedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistric(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public String getUnionname() {
        return unionname;
    }

    public void setUnionname(String unionname) {
        this.unionname = unionname;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Timestamp addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", userId=" + userId + ", division=" + division + ", district=" + district + ", subdistrict=" + subdistrict + ", unionname=" + unionname + ", zip=" + zip + ", address=" + address + ", addedAt=" + addedAt + '}';
    }
    
    
    
}
