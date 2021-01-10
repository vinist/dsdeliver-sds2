package com.github.vinist.dsdeliver.services;

import com.github.vinist.dsdeliver.dto.OrderDto;
import com.github.vinist.dsdeliver.dto.ProductDto;
import com.github.vinist.dsdeliver.repositories.OrderRepository;
import com.github.vinist.dsdeliver.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        var orders = orderRepository.findOrdersWithPendingProductsOrderByMoment();
        return orders.stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
