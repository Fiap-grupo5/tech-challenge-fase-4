package com.fiap.g5.mslogistic.usecase;

import com.fiap.g5.mslogistic.domain.Logistic;
import com.fiap.g5.mslogistic.gateway.LogisticGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateLogisticUseCase {

    private final LogisticGateway logisticGateway;

    public Logistic execute(Long id, Logistic updatedLogistic) {
        log.info("Atualizando registro de logística com ID {}: {}", id, updatedLogistic);
        return logisticGateway.update(id, updatedLogistic);
    }
}
