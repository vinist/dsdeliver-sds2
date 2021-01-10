package com.github.vinist.dsdeliver.controllers;

import com.github.vinist.dsdeliver.dto.OrderDto;
import com.github.vinist.dsdeliver.dto.ProductDto;
import com.github.vinist.dsdeliver.services.OrderService;
import com.github.vinist.dsdeliver.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    
    @PostMapping
    public ResponseEntity<OrderDto> insert(@RequestBody OrderDto dto) {
        dto =orderService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    
    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDto> setDelivered(@PathVariable Long id){
        var order = orderService.setDelivered(id);
        return ResponseEntity.ok().body(order);
    }
}
