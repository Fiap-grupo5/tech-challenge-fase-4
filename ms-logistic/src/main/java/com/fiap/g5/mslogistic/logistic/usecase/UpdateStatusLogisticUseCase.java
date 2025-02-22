package com.fiap.g5.mslogistic.logistic.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.Logistic;
import com.fiap.g5.mslogistic.logistic.domain.LogisticStatus;
import com.fiap.g5.mslogistic.logistic.domain.OrderStatus;
import com.fiap.g5.mslogistic.logistic.gateway.LogisticGateway;
import com.fiap.g5.mslogistic.logistic.gateway.OrderGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateStatusLogisticUseCase {
    private LogisticGateway logisticGateway;
    private OrderGateway orderGateway;
    private UpdateLogisticDeliveryDateUseCase updateLogisticDeliveryDateUseCase;

    public Logistic updateStatus(Long id, String status) {
        var logistic = logisticGateway.findById(id);
        if (logistic == null) {
            return null;
        }

        var newStatus = LogisticStatus.fromString(status);

        if (newStatus == null) {
            throw new IllegalArgumentException("Invalid status");
        }

        var currentStatus = LogisticStatus.fromString(logistic.getStatus());

        if (!currentStatus.canTransitionTo(newStatus)) {
            throw new IllegalArgumentException("Invalid status transition");
        }

        if (LogisticStatus.IN_TRANSIT.getStatus().equals(status) && logistic.getDelivery() == null) {
            throw new IllegalArgumentException("Delivery is required");
        }

        if (LogisticStatus.CANCELED.getStatus().equals(status)) {
            orderGateway.updateStatus(id, OrderStatus.CANCELED.getStatus());
        }

        if (LogisticStatus.DELIVERED.getStatus().equals(status)) {
            orderGateway.updateStatus(id, OrderStatus.SUCCESS.getStatus());
            updateLogisticDeliveryDateUseCase.updateDeliveryDate(id, LocalDateTime.now());
        }

        return logisticGateway.updateStatus(id, status);
    }
}
