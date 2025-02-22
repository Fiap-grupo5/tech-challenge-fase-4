package com.fiap.g5.mslogistic.logistic.usecase;

import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.Logistic;
import com.fiap.g5.mslogistic.logistic.gateway.LogisticGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindLogisticByIdUseCase {
    private LogisticGateway logisticGateway;

    public Logistic findById(Long id) {
        return logisticGateway.findById(id);
    }
}
