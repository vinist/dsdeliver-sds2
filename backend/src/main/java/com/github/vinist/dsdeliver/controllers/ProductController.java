package com.github.vinist.dsdeliver.controllers;

import com.github.vinist.dsdeliver.dto.ProductDto;
import com.github.vinist.dsdeliver.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    private final ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        var products = productService.findAll();
        return ResponseEntity.ok().body(products);
    }
}
