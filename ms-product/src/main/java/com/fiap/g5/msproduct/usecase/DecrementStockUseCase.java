package com.fiap.g5.msproduct.usecase;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DecrementStockUseCase {
    private final ProductGateway productGateway;

    public Product execute(Long id, int quantity) {
        log.info("Decrementando estoque do produto com ID {} em {} unidades", id, quantity);
        return productGateway.decrementStock(id, quantity);
    }
}
