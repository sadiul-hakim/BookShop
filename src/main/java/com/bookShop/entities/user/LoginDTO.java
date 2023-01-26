package com.bookShop.entities.user;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Hakim
 */
public class LoginDTO {
    @NotEmpty
    @Length(min = 12,max=30)
    private String email;
    @NotEmpty
    @Length(min = 8,max=16)
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
