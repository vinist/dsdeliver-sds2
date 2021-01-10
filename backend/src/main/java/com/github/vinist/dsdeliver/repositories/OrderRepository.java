package com.github.vinist.dsdeliver.repositories;

import com.github.vinist.dsdeliver.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
    @Query("select distinct o " +
            " from Order o " +
            " join fetch o.products p " +
            " where o.status = 0 " +
            " order by o.moment asc")
    List<Order> findOrdersWithPendingProductsOrderByMoment();
}
