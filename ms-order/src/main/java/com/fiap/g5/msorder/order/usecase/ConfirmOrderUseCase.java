package com.fiap.g5.msorder.order.usecase;

import com.fiap.g5.msorder.order.domain.Order;
import com.fiap.g5.msorder.order.domain.OrderStatus;
import com.fiap.g5.msorder.order.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfirmOrderUseCase {

    private final OrderGateway orderGateway;
    private final FindOrderByIdUseCase findOrderByIdUseCase;

    public Order execute(Long orderId) {
        log.info("Confirmando pedido com ID {}", orderId);
        Order existing = findOrderByIdUseCase.execute(orderId);
        if (existing.getStatus() == OrderStatus.CONFIRMED) {
            return existing;
        }
        existing.setStatus(OrderStatus.CONFIRMED);
        existing.setUpdatedAt(LocalDateTime.now());
        return orderGateway.update(orderId, existing);
    }
}
