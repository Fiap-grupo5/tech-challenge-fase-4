package com.fiap.g5.msorder.usecase;

import com.fiap.g5.msorder.domain.Order;
import com.fiap.g5.msorder.exception.OrderNotFoundException;
import com.fiap.g5.msorder.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindOrderByIdUseCase {

    private final OrderGateway orderGateway;

    public Order execute(Long orderId) {
        return orderGateway.findById(orderId)
                .orElseThrow(OrderNotFoundException::new);
    }
}
