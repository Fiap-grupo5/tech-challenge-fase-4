package com.fiap.g5.mslogistic.usecase;

import com.fiap.g5.mslogistic.gateway.LogisticGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteLogisticUseCase {

    private final LogisticGateway logisticGateway;

    public void execute(Long id) {
        log.info("Deletando registro de logística com ID {}", id);
        logisticGateway.delete(id);
    }
}
