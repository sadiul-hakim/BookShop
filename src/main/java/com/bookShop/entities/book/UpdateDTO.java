package com.bookShop.entities.book;

/**
 *
 * @author Hakim
 */
public class UpdateDTO {
    private String name;
    private String status;
    private String description;
    private String photo;
    private int price;

    public UpdateDTO() {
    }

    public UpdateDTO(String name, String status, String description, String photo, int price) {
        this.name = name;
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
        return "UpdateDTO{" + "name=" + name + ", status=" + status + ", description=" + description + ", photo=" + photo + ", price=" + price + '}';
    }
    
    
}
