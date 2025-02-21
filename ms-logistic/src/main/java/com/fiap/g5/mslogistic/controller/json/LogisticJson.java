package com.fiap.g5.mslogistic.controller.json;

import com.fiap.g5.mslogistic.domain.Logistic;
import com.fiap.g5.mslogistic.domain.LogisticStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LogisticJson {
    private Long id;
    private Long orderId;
    private String delivery;
    private LogisticStatus status;
    private LocalDateTime estimatedDate;
    private LocalDateTime deliveryDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LogisticJson(Logistic logistic) {
        this.id = logistic.getId();
        this.orderId = logistic.getOrderId();
        this.delivery = logistic.getDelivery();
        this.status = logistic.getStatus();
        this.estimatedDate = logistic.getEstimatedDate();
        this.deliveryDate = logistic.getDeliveryDate();
        this.createdAt = logistic.getCreatedAt();
        this.updatedAt = logistic.getUpdatedAt();
    }
}
