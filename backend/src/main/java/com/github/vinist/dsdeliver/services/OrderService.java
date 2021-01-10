package com.github.vinist.dsdeliver.services;

import com.github.vinist.dsdeliver.dto.OrderDto;
import com.github.vinist.dsdeliver.dto.ProductDto;
import com.github.vinist.dsdeliver.entities.Order;
import com.github.vinist.dsdeliver.entities.OrderStatus;
import com.github.vinist.dsdeliver.repositories.OrderRepository;
import com.github.vinist.dsdeliver.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    
    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }
    
    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        var orders = orderRepository.findOrdersWithPendingProductsOrderByMoment();
        return orders.stream().map(OrderDto::new).collect(Collectors.toList());
    }
    
    @Transactional
    public OrderDto insert(OrderDto dto) {
        var order = new Order(dto);
        for(ProductDto p: dto.getProducts()) {
            order.getProducts().add(productRepository.getOne(p.getId()));
        }
        order = orderRepository.save(order);
        return new OrderDto(order);
    }
    
    @Transactional
    public OrderDto setDelivered(Long id) {
        Order order = orderRepository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = orderRepository.save(order);
        return new OrderDto(order);
        
    }
}
