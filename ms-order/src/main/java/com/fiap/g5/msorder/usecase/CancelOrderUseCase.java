package com.fiap.g5.msorder.usecase;

import com.fiap.g5.msorder.config.stream.StockUpdateProducer;
import com.fiap.g5.msorder.domain.Order;
import com.fiap.g5.msorder.domain.OrderStatus;
import com.fiap.g5.msorder.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CancelOrderUseCase {

    private final OrderGateway orderGateway;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final StockUpdateProducer stockUpdateProducer;

    public Order execute(Long orderId) {
        log.info("Cancelando pedido com ID {}", orderId);

        Order existing = findOrderByIdUseCase.execute(orderId);
        if (existing.getStatus() == OrderStatus.CANCELED) {
            return existing;
        }

        existing.getItems().forEach(item -> {
            stockUpdateProducer.sendStockUpdateEvent(
                    item.getProductId(),
                    item.getQuantity(),
                    true 
            );
        });

        existing.setStatus(OrderStatus.CANCELED);
        existing.setUpdatedAt(LocalDateTime.now());

        return orderGateway.update(orderId, existing);
    }
}
