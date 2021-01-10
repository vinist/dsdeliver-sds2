package com.github.vinist.dsdeliver.services;

import com.github.vinist.dsdeliver.dto.ProductDto;
import com.github.vinist.dsdeliver.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        var products = productRepository.findAllByOrderByNameAsc();
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
