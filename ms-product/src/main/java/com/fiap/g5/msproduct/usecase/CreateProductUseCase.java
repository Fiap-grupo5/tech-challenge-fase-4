package com.fiap.g5.msproduct.usecase;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateProductUseCase {
    private final ProductGateway productGateway;

    public Product execute(Product product) {
        log.info("Criando novo produto: {}", product);
        return productGateway.create(product);
    }
}
