package com.fiap.g5.msorder.order.usecase;

import com.fiap.g5.msorder.order.domain.Order;
import com.fiap.g5.msorder.order.domain.OrderStatus;
import com.fiap.g5.msorder.order.gateway.OrderGateway;
import com.fiap.g5.msorder.order.gateway.ProdutoGateway;
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
    private final ProdutoGateway produtoGateway; 

    public Order execute(Long orderId) {
        log.info("Cancelando pedido com ID {}", orderId);
        Order existing = findOrderByIdUseCase.execute(orderId);
        if (existing.getStatus() == OrderStatus.CANCELED) {
            return existing;
        }

        existing.getItems().forEach(item -> {
            produtoGateway.incrementarEstoque(item.getProductId(), item.getQuantity());
        });
        existing.setStatus(OrderStatus.CANCELED);
        existing.setUpdatedAt(LocalDateTime.now());

        return orderGateway.update(orderId, existing);
    }
}
