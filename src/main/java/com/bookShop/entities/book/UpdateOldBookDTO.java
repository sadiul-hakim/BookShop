package com.bookShop.entities.book;

/**
 *
 * @author Hakim
 */
public class UpdateOldBookDTO {
    private String name;
    private int price;
    private String photo;

    public UpdateOldBookDTO() {
    }

    public UpdateOldBookDTO(String name, int price, String photo) {
        this.name = name;
        this.price = price;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "UpdateOldBookDTO{" + "name=" + name + ", price=" + price + ", photo=" + photo + '}';
    }
    
    
}
