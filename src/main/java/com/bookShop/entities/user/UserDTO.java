package com.bookShop.entities.user;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Hakim
 */
public class UserDTO {
    @NotEmpty
    @Length(min = 5,max=30)
    private String name;
    @NotEmpty
    @Length(min = 12,max=30)
    private String email;
    @NotEmpty
    @Length(min = 8,max=15)
    private String phone;
    @NotEmpty
    @Length(min = 5,max=50)
    private String photo;
    @NotEmpty
    @Length(min = 5,max=10)
    private String role;
    @NotEmpty
    @Length(min = 8,max=16)
    private String password;

    public UserDTO() {
    }

    public UserDTO(String name, String email, String phone, String photo, String role, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.role = role;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "name=" + name + ", email=" + email + ", phone=" + phone + ", photo=" + photo + ", role=" + role + ", password=" + password + '}';
    }
    
    
    
}
