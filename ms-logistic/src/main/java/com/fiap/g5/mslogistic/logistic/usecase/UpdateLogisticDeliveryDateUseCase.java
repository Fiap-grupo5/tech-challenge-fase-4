package com.fiap.g5.mslogistic.logistic.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.Logistic;
import com.fiap.g5.mslogistic.logistic.gateway.LogisticGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateLogisticDeliveryDateUseCase {
    private LogisticGateway logisticGateway;

    public Logistic updateDeliveryDate(Long id, LocalDateTime deliveryDate) {
        var logistic = logisticGateway.findById(id);
        if (logistic == null) {
            return null;
        }

        return logisticGateway.updateDeliveryDate(id, deliveryDate);
    }
}
