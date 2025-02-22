package com.fiap.g5.msproduct.usecase;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.exception.ProductNotFoundException;
import com.fiap.g5.msproduct.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindProductByIdUseCase {
    private final ProductGateway productGateway;

    public Product execute(Long id) {
        return productGateway.findById(id)
                .orElseThrow(() -> {
                    log.warn("Product not found with id: {}", id);
                    return new ProductNotFoundException();
                });
    }
}
