package com.fiap.g5.msorder.order.gateway;

public interface ProdutoGateway {
    void decrementarEstoque(Long productId, int quantidade);
    void incrementarEstoque(Long productId, int quantidade);
}
