package com.bookShop.entities.book;

/**
 *
 * @author Hakim
 */
public class Cart {
    private int bookId;
    private int quantity;
    private String bookName;
    private int price;
    private int totalPrice;
    private String bookPhoto;

    public Cart() {
    }

    public Cart(int bookId, int quantity, String bookName, int price, String bookPhoto) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.bookName = bookName;
        this.price = price;
        this.bookPhoto = bookPhoto;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return quantity*price;
    }

    public String getBookPhoto() {
        return bookPhoto;
    }

    public void setBookPhoto(String bookPhoto) {
        this.bookPhoto = bookPhoto;
    }
    
    public void incrementQuantityByOne(){
        this.quantity+=1;
    }
    
    public void decrementQuantityByOne(){
        this.quantity-=1;
    }
    
    
}
