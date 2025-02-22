package com.fiap.g5.msorder.order.gateway;

import com.fiap.g5.msorder.order.gateway.api.feign.ProdutoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoGatewayImpl implements ProdutoGateway {
    private final ProdutoClient produtoClient;
    
    @Override
    public void decrementarEstoque(Long productId, int quantidade) {
        produtoClient.decrementStock(productId, quantidade);
    }
    
    @Override
    public void incrementarEstoque(Long productId, int quantidade) {
        produtoClient.incrementStock(productId, quantidade);
    }
}
