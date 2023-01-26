package com.bookShop.bean;

import com.bookShop.entities.book.Cart;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hakim
 */
public class CartBean {
    private HttpSession session;
    private int totalPrice;
    private int totalQuantity;
    private List<Cart> cart;

    public List<Cart> getCart() {
        Object obj = session.getAttribute("cart");
        if(obj==null){
            cart=new ArrayList<>();
        }else{
            cart=(List<Cart>) obj;
        }
        return cart;
    }

    public int getTotalQuantity() {
        List<Cart> cart=(List<Cart>) session.getAttribute("cart");
        if(cart==null){
            return 0;
        }
        int total=0;
        for(Cart c:cart){
            total+=c.getQuantity();
        }
        return total;
    }

    
    
    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public int getTotalPrice() {
        List<Cart> cart=(List<Cart>) session.getAttribute("cart");
        if(cart==null){
            return 0;
        }
        int newTotalPrice=0;
        for(Cart c:cart){
            newTotalPrice+=c.getTotalPrice();
        }
        return newTotalPrice;
    }
    
    
    
}
