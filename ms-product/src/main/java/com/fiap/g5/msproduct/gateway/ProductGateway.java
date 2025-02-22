package com.fiap.g5.msproduct.gateway;

import com.fiap.g5.msproduct.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductGateway {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product create(Product product);
    Product update(Long id, Product product);
    void delete(Long id);
    Product incrementStock(Long id, int quantity);
    Product decrementStock(Long id, int quantity);
}
