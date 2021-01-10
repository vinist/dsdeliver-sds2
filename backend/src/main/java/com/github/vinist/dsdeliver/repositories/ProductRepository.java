package com.github.vinist.dsdeliver.repositories;

import com.github.vinist.dsdeliver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findAllByOrderByNameAsc();
}
