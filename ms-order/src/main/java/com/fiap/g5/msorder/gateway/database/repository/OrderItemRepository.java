package com.fiap.g5.msorder.gateway.database.repository;

import com.fiap.g5.msorder.gateway.database.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
