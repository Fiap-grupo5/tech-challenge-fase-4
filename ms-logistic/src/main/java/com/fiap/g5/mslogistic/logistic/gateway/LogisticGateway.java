package com.fiap.g5.mslogistic.logistic.gateway;

import java.time.LocalDateTime;
import java.util.List;

import com.fiap.g5.mslogistic.logistic.domain.CreateLogistic;
import com.fiap.g5.mslogistic.logistic.domain.Logistic;

public interface LogisticGateway {
    Logistic create(CreateLogistic createLogistic);
    Logistic findById(Long id);
    Logistic updateStatus(Long id, String status);
    Logistic updateDeliveryDate(Long id, LocalDateTime deliveryDate);
    Logistic updateDelivery(Long id, String delivery);
    List<Logistic> findAll();
}
