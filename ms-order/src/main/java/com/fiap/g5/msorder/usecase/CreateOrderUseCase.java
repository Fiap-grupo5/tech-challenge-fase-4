package com.fiap.g5.msorder.usecase;

import com.fiap.g5.msorder.config.stream.StockUpdateProducer;
import com.fiap.g5.msorder.domain.Order;
import com.fiap.g5.msorder.domain.OrderItem;
import com.fiap.g5.msorder.domain.OrderStatus;
import com.fiap.g5.msorder.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final OrderGateway orderGateway;
    private final StockUpdateProducer stockUpdateProducer;

    public Order execute(Order order) {
        log.info("Criando novo pedido: {}", order);

        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        for (OrderItem item : order.getItems()) {
            stockUpdateProducer.sendStockUpdateEvent(
                    item.getProductId(),
                    item.getQuantity(),
                    false
            );
        }

        return orderGateway.create(order);
    }
}
