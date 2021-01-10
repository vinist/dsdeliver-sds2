package com.github.vinist.dsdeliver.dto;

import com.github.vinist.dsdeliver.entities.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ProductDto implements Serializable {
    
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;
    
    public ProductDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.description = entity.getDescription();
        this.imageUri = entity.getImageUri();
    }
}
