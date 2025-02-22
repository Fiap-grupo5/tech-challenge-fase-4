package com.fiap.g5.msorder.order.gateway.database;

import com.fiap.g5.msorder.order.domain.Order;
import com.fiap.g5.msorder.order.domain.OrderStatus;
import com.fiap.g5.msorder.order.exception.OrderNotFoundException;
import com.fiap.g5.msorder.order.gateway.OrderGateway;
import com.fiap.g5.msorder.order.gateway.database.entity.OrderEntity;
import com.fiap.g5.msorder.order.gateway.database.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryGateway implements OrderGateway {

    private final OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        OrderEntity entity = toEntity(order);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        OrderEntity saved = orderRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Order update(Long id, Order order) {
        OrderEntity existing = orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);
        existing.setCustomerId(order.getCustomerId());
        existing.setStatus(order.getStatus());
        existing.setPostcode(order.getPostcode());
        existing.setNumber(order.getNumber());
        existing.setTotal(order.getTotal());
        existing.setUpdatedAt(LocalDateTime.now());
        OrderEntity updated = orderRepository.save(existing);
        return toDomain(updated);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id)
                .map(this::toDomain);
    }

    private Order toDomain(OrderEntity entity) {
        Order order = new Order();
        order.setId(entity.getId());
        order.setCustomerId(entity.getCustomerId());
        order.setStatus(entity.getStatus());
        order.setPostcode(entity.getPostcode());
        order.setNumber(entity.getNumber());
        order.setTotal(entity.getTotal());
        order.setCreatedAt(entity.getCreatedAt());
        order.setUpdatedAt(entity.getUpdatedAt());
        return order;
    }

    private OrderEntity toEntity(Order order) {
        return OrderEntity.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .status(order.getStatus() == null ? OrderStatus.PENDING : order.getStatus())
                .postcode(order.getPostcode())
                .number(order.getNumber())
                .total(order.getTotal())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }
}
