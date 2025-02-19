package com.fiap.g5.mslogistic.usecase;

import com.fiap.g5.mslogistic.domain.Logistic;
import com.fiap.g5.mslogistic.exception.LogisticNotFoundException;
import com.fiap.g5.mslogistic.gateway.LogisticGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindLogisticByIdUseCase {

    private final LogisticGateway logisticGateway;

    public Logistic execute(Long id) {
        return logisticGateway.findById(id)
                .orElseThrow(() -> {
                    log.warn("Logistic not found with id: {}", id);
                    return new LogisticNotFoundException();
                });
    }
}
