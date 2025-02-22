package com.fiap.g5.mslogistic.logistic.usecase;

import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.Delivery;
import com.fiap.g5.mslogistic.logistic.domain.Logistic;
import com.fiap.g5.mslogistic.logistic.gateway.LogisticGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateLogisticDelivery {
    private LogisticGateway logisticGateway;

    public Logistic updateDelivery(Long id, String delivery) {
        var logistic = logisticGateway.findById(id);
        if (logistic == null) {
            return null;
        }

        var currentDelivery = logistic.getDelivery();

        if (currentDelivery != null) {
            throw new IllegalArgumentException("Delivery already set");
        }

        var newDelivery = Delivery.fromString(delivery);

        if (newDelivery == null) {
            throw new IllegalArgumentException("Invalid delivery");
        }

        return logisticGateway.updateDelivery(id, delivery);
    }
}
