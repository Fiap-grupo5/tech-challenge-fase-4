package com.fiap.g5.msproduct.service;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product update(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            product.setCategory(updatedProduct.getCategory());
            
            product.setUpdatedAt(LocalDateTime.now());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product incrementStock(Long id, int quantity) {
        return productRepository.findById(id).map(product -> {
            product.incrementStock(quantity);
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product decrementStock(Long id, int quantity) {
        return productRepository.findById(id).map(product -> {
            product.decrementStock(quantity);
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

}

