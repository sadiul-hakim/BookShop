package com.bookShop.entities.book;

import java.sql.Timestamp;

/**
 *
 * @author Hakim
 */
public class OldBook {

    private int id;
    private String name;
    private String author;
    private String photo;
    private int price;
    private String category;
    private int userId;
    private String userName;
    private Timestamp addedAt;

    public OldBook() {
    }

    public OldBook(int id, String name, String author, String category, String photo, int price, int userId, String userName, Timestamp addedAt) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.photo = photo;
        this.price = price;
        this.userId = userId;
        this.userName = userName;
        this.addedAt = addedAt;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Timestamp addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "OldBook{" + "id=" + id + ", name=" + name + ", author=" + author + ", category=" + category + ", photo=" + photo + ", price=" + price + ", userId=" + userId + ", userName=" + userName + ", addedAt=" + addedAt + '}';
    }

}
