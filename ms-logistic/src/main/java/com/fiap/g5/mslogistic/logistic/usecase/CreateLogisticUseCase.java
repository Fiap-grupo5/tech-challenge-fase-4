package com.fiap.g5.mslogistic.logistic.usecase;

import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.CreateLogistic;
import com.fiap.g5.mslogistic.logistic.domain.Logistic;
import com.fiap.g5.mslogistic.logistic.gateway.LogisticGateway;
import com.fiap.g5.mslogistic.logistic.gateway.OrderGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateLogisticUseCase {
    private LogisticGateway logisticGateway;
    private OrderGateway    orderGateway;

    public Logistic create(CreateLogistic createLogistic) {
        var order = orderGateway.findById(createLogistic.getOrderId());
        if (order == null) {
            return null;
        }
        return logisticGateway.create(createLogistic);
    }
}
