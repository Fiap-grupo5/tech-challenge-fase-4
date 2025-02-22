package com.fiap.g5.msproduct.usecase;

import com.fiap.g5.msproduct.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteProductUseCase {
    private final ProductGateway productGateway;

    public void execute(Long id) {
        log.info("Deletando produto com ID {}", id);
        productGateway.delete(id);
    }
}
