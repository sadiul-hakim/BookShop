package com.bookShop.entities.book;

import java.sql.Timestamp;

/**
 *
 * @author Hakim
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private String category;
    private String status;
    private String description;
    private String photo;
    private int price;
    private Timestamp addedAt;

    public Book() {
    }

    public Book(int id, String name, String author, String category, String status, String description, String photo, int price, Timestamp addedAt) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.status = status;
        this.description = description;
        this.photo = photo;
        this.price = price;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Timestamp getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Timestamp addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", author=" + author + ", category=" + category + ", status=" + status + ", description=" + description + ", photo=" + photo + ", price=" + price + ", addedAt=" + addedAt + '}';
    }
    
}
