package com.bookShop.entities.book;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Hakim
 */
public class OldBookDTO {
    @NotEmpty
    @Length(min=4,max=30)
    private String name;
    @NotEmpty
    @Length(min=4,max=30)
    private String author;
    @NotEmpty
    @Length(min=4,max=30)
    private String photo;
    private int price;
    @NotEmpty
    private String category;
    private int userId;
    @NotEmpty
    @Length(min=4,max=30)
    private String userName;

    public OldBookDTO() {
    }

    public OldBookDTO(String name, String author, String photo, int price, String category, int userId, String userName) {
        this.name = name;
        this.author = author;
        this.photo = photo;
        this.price = price;
        this.category = category;
        this.userId = userId;
        this.userName = userName;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    
    
    
}
