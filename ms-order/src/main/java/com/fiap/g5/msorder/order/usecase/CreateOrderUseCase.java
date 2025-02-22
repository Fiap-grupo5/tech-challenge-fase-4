package com.fiap.g5.msorder.order.usecase;

import com.fiap.g5.msorder.order.domain.Order;
import com.fiap.g5.msorder.order.domain.OrderItem;
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
public class CreateOrderUseCase {

    private final OrderGateway orderGateway;
    private final ProdutoGateway produtoGateway;
    public Order execute(Order order) {
        log.info("Criando novo pedido: {}", order);
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        for (OrderItem item : order.getItems()) {
            produtoGateway.decrementarEstoque(item.getProductId(), item.getQuantity());
        }
        
        return orderGateway.create(order);
    }
}
