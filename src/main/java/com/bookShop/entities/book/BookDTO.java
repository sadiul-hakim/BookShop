package com.bookShop.entities.book;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Hakim
 */
public class BookDTO {
    @NotEmpty
    @Length(min=5,max=40)
    private String name;
    @NotEmpty
    @Length(min=4,max=40)
    private String author;
    @NotEmpty
    @Length(min=3,max=40)
    private String category;
    @NotEmpty
    @Length(min=3,max=40)
    private String status;
    @NotEmpty
    @Length(min=10,max=300)
    private String description;
    @NotEmpty
    @Length(min=3,max=40)
    private String photo;
    private int price;

    public BookDTO() {
    }

    public BookDTO(String name, String author, String category, String status, String description, String photo, int price) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.status = status;
        this.description = description;
        this.photo = photo;
        this.price = price;
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

    @Override
    public String toString() {
        return "BookDTO{" + "name=" + name + ", author=" + author + ", category=" + category + ", status=" + status + ", description=" + description + ", photo=" + photo + ", price=" + price + '}';
    }
    
    
}
