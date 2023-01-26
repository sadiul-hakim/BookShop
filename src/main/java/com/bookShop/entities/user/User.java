package com.bookShop.entities.user;

import java.sql.Timestamp;

/**
 *
 * @author Hakim
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String photo;
    private String role;
    private String password;
    private Timestamp joinedAt;

    public User() {
    }

    public User(int id, String name, String email, String phone, String photo, String role, String password, Timestamp joinedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.role = role;
        this.password = password;
        this.joinedAt = joinedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Timestamp joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", photo=" + photo + ", role=" + role + ", password=" + password + ", joinedAt=" + joinedAt + '}';
    }

}
