package com.github.vinist.dsdeliver.controllers;

import com.github.vinist.dsdeliver.dto.OrderDto;
import com.github.vinist.dsdeliver.dto.ProductDto;
import com.github.vinist.dsdeliver.services.OrderService;
import com.github.vinist.dsdeliver.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    
    private final OrderService orderService;
    
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll() {
        var orders = orderService.findAll();
        return ResponseEntity.ok().body(orders);
    }
}
