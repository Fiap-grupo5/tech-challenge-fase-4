package com.fiap.g5.msorder.order.gateway;

import com.fiap.g5.msorder.order.domain.Order;
import java.util.List;
import java.util.Optional;

public interface OrderGateway {
    Order create(Order order);
    Order update(Long id, Order order);
    void delete(Long id);
    List<Order> findAll();
    Optional<Order> findById(Long id);
}
