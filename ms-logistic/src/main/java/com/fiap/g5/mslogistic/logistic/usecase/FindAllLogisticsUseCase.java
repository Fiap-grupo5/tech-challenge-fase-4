package com.fiap.g5.mslogistic.logistic.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.Logistic;
import com.fiap.g5.mslogistic.logistic.gateway.LogisticGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindAllLogisticsUseCase {
    private LogisticGateway logisticGateway;

    public List<Logistic> findAll() {
        return logisticGateway.findAll();
    }
}
