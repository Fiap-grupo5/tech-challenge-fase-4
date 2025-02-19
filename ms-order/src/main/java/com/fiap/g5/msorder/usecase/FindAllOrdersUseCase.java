package com.fiap.g5.msorder.usecase;

import com.fiap.g5.msorder.domain.Order;
import com.fiap.g5.msorder.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllOrdersUseCase {

    private final OrderGateway orderGateway;

    public List<Order> execute() {
        return orderGateway.findAll();
    }
}
