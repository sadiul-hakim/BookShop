package com.bookShop.entities.address;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Hakim
 */
public class AddressDTO {
    private int userId;
    @NotEmpty
    @Length(min = 5, max = 25)
    private String division;
    @NotEmpty
    @Length(min = 5, max = 25)
    private String district;
    @NotEmpty
    @Length(min = 5, max = 25)
    private String subdistrict;
    @NotEmpty
    @Length(min = 5, max = 25)
    private String unionname;
    private int zip;
    @NotEmpty
    @Length(min = 5, max = 200)
    private String address;

    public AddressDTO() {
    }

    public AddressDTO(int userId, String division, String district, String subdistrict, String unionname, int zip, String address) {
        this.userId = userId;
        this.division = division;
        this.district = district;
        this.subdistrict = subdistrict;
        this.unionname = unionname;
        this.zip = zip;
        this.address = address;
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

    public void setSubdistrict(String subdistrict) {
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

    @Override
    public String toString() {
        return "AddressDTO{" + "userId=" + userId + ", division=" + division + ", district=" + district + ", subdistric=" + subdistrict + ", unionname=" + unionname + ", zip=" + zip + ", address=" + address + '}';
    }

}
