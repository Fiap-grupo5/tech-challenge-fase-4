package com.fiap.g5.msorder.order.gateway.database.repository;

import com.fiap.g5.msorder.order.gateway.database.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
