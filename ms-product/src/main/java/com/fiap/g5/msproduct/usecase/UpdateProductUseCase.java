package com.fiap.g5.msproduct.usecase;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateProductUseCase {

    private final ProductGateway productGateway;

    public Product execute(Long id, Product updatedProduct) {
        log.info("Atualizando produto com ID {}: {}", id, updatedProduct);
        return productGateway.update(id, updatedProduct);
    }
}
