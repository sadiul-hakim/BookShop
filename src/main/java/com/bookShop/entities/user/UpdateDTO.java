package com.bookShop.entities.user;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Hakim
 */
public class UpdateDTO {
    @NotEmpty
    @Length(min = 3,max=30)
    private String name;
    @NotEmpty
    @Length(min = 3,max=50)
    private String photo;

    public UpdateDTO() {
    }

    public UpdateDTO(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    
}
