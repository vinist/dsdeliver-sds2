package com.github.vinist.dsdeliver.repositories;

import com.github.vinist.dsdeliver.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
