package com.fiap.g5.mslogistic.usecase;

import com.fiap.g5.mslogistic.domain.Logistic;
import com.fiap.g5.mslogistic.gateway.LogisticGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateLogisticUseCase {

    private final LogisticGateway logisticGateway;

    public Logistic execute(Logistic logistic) {
        log.info("Criando novo registro de logística: {}", logistic);
        return logisticGateway.create(logistic);
    }
}
