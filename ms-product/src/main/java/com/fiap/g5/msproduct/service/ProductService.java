package com.fiap.g5.msproduct.service;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.gateway.ProductGateway;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductGateway productGateway;

    public ProductService(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public List<Product> findAll() {
        return productGateway.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productGateway.findById(id);
    }

    public Product create(Product product) {
        return productGateway.create(product);
    }

    public Product update(Long id, Product updatedProduct) {
        return productGateway.update(id, updatedProduct);
    }

    public void delete(Long id) {
        productGateway.delete(id);
    }

    public Product incrementStock(Long id, int quantity) {
        return productGateway.incrementStock(id, quantity);
    }

    public Product decrementStock(Long id, int quantity) {
        return productGateway.decrementStock(id, quantity);
    }
}
