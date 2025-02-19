package com.fiap.g5.mslogistic.usecase;

import com.fiap.g5.mslogistic.domain.Logistic;
import com.fiap.g5.mslogistic.gateway.LogisticGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllLogisticsUseCase {

    private final LogisticGateway logisticGateway;

    public List<Logistic> execute() {
        return logisticGateway.findAll();
    }
}
