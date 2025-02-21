package com.fiap.g5.msorder.gateway.database;

import com.fiap.g5.msorder.domain.Order;
import com.fiap.g5.msorder.domain.OrderItem;
import com.fiap.g5.msorder.exception.OrderNotFoundException;
import com.fiap.g5.msorder.exception.SystemBaseException;
import com.fiap.g5.msorder.gateway.OrderGateway;
import com.fiap.g5.msorder.gateway.database.entity.OrderEntity;
import com.fiap.g5.msorder.gateway.database.entity.OrderItemEntity;
import com.fiap.g5.msorder.gateway.database.repository.OrderRepository;
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
        try {
            OrderEntity entity = toEntity(order);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setUpdatedAt(LocalDateTime.now());

            // Ajustar itens para apontar para a mesma entidade
            entity.getItems().forEach(item -> {
                item.setOrder(entity);
                item.setCreatedAt(LocalDateTime.now());
                item.setUpdatedAt(LocalDateTime.now());
            });

            OrderEntity saved = orderRepository.save(entity);
            return toDomain(saved);
        } catch (Exception e) {
            log.error("Erro ao criar pedido", e);
            throw new SystemBaseException() {
                @Override
                public String getCode() { return "order-service.errorCreatingOrder"; }
                @Override
                public Integer getHttpStatus() { return 500; }
                @Override
                public String getMessage() { return "Error creating order"; }
            };
        }
    }

    @Override
    public Order update(Long id, Order order) {
        try {
            OrderEntity existing = orderRepository.findById(id)
                    .orElseThrow(OrderNotFoundException::new);

            existing.setCustomerId(order.getCustomerId());
            existing.setStatus(order.getStatus());
            existing.setUpdatedAt(LocalDateTime.now());

            existing.getItems().clear();
            order.getItems().forEach(item -> {
                OrderItemEntity itemEntity = toItemEntity(item);
                itemEntity.setOrder(existing);
                itemEntity.setCreatedAt(LocalDateTime.now());
                itemEntity.setUpdatedAt(LocalDateTime.now());
                existing.getItems().add(itemEntity);
            });

            OrderEntity updated = orderRepository.save(existing);
            return toDomain(updated);
        } catch (OrderNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Erro ao atualizar pedido", e);
            throw new SystemBaseException() {
                @Override
                public String getCode() { return "order-service.errorUpdatingOrder"; }
                @Override
                public Integer getHttpStatus() { return 500; }
                @Override
                public String getMessage() { return "Error updating order"; }
            };
        }
    }

    @Override
    public void delete(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Erro ao deletar pedido", e);
            throw new SystemBaseException() {
                @Override
                public String getCode() { return "order-service.errorDeletingOrder"; }
                @Override
                public Integer getHttpStatus() { return 500; }
                @Override
                public String getMessage() { return "Error deleting order"; }
            };
        }
    }

    @Override
    public List<Order> findAll() {
        try {
            return orderRepository.findAll().stream()
                    .map(this::toDomain)
                    .toList();
        } catch (Exception e) {
            log.error("Erro ao buscar todos os pedidos", e);
            throw new SystemBaseException() {
                @Override
                public String getCode() { return "order-service.errorFindingOrders"; }
                @Override
                public Integer getHttpStatus() { return 500; }
                @Override
                public String getMessage() { return "Error finding orders"; }
            };
        }
    }

    @Override
    public Optional<Order> findById(Long id) {
        try {
            return orderRepository.findById(id).map(this::toDomain);
        } catch (Exception e) {
            log.error("Erro ao buscar pedido por ID", e);
            throw new SystemBaseException() {
                @Override
                public String getCode() { return "order-service.errorFindingOrderById"; }
                @Override
                public Integer getHttpStatus() { return 500; }
                @Override
                public String getMessage() { return "Error finding order by id"; }
            };
        }
    }

    private OrderEntity toEntity(Order order) {
        var entity = OrderEntity.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();

        order.getItems().forEach(item -> {
            var itemEntity = toItemEntity(item);
            itemEntity.setOrder(entity);
            entity.getItems().add(itemEntity);
        });

        return entity;
    }

    private OrderItemEntity toItemEntity(OrderItem item) {
        return OrderItemEntity.builder()
                .id(item.getId())
                .productId(item.getProductId())
                .quantity(item.getQuantity())
                .createdAt(item.getCreatedAt())
                .updatedAt(item.getUpdatedAt())
                .build();
    }

    private Order toDomain(OrderEntity entity) {
        Order order = new Order();
        order.setId(entity.getId());
        order.setCustomerId(entity.getCustomerId());
        order.setStatus(entity.getStatus());
        order.setCreatedAt(entity.getCreatedAt());
        order.setUpdatedAt(entity.getUpdatedAt());

        entity.getItems().forEach(itemEntity -> {
            OrderItem item = new OrderItem();
            item.setId(itemEntity.getId());
            item.setProductId(itemEntity.getProductId());
            item.setQuantity(itemEntity.getQuantity());
            item.setCreatedAt(itemEntity.getCreatedAt());
            item.setUpdatedAt(itemEntity.getUpdatedAt());
            order.getItems().add(item);
        });

        return order;
    }
}
