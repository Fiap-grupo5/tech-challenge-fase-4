package com.fiap.g5.msproduct.gateway.database;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.exception.DataRepositoryAccessException;
import com.fiap.g5.msproduct.exception.ProductNotFoundException;
import com.fiap.g5.msproduct.gateway.ProductGateway;
import com.fiap.g5.msproduct.gateway.database.entity.ProductEntity;
import com.fiap.g5.msproduct.gateway.database.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductRepositoryGateway implements ProductGateway {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        try {
            return productRepository.findAll()
                    .stream()
                    .map(this::toDomain)
                    .toList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        try {
            return productRepository.findById(id).map(this::toDomain);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Product create(Product product) {
        try {
            ProductEntity entity = toEntity(product);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setUpdatedAt(LocalDateTime.now());
            ProductEntity saved = productRepository.save(entity);
            return toDomain(saved);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Product update(Long id, Product product) {
        try {
            ProductEntity existing = productRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);

            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setCategory(product.getCategory());
            existing.setPrice(product.getPrice());
            existing.setStock(product.getStock());
            existing.setUpdatedAt(LocalDateTime.now());

            ProductEntity updated = productRepository.save(existing);
            return toDomain(updated);
        } catch (ProductNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Product incrementStock(Long id, int quantity) {
        try {
            ProductEntity existing = productRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);

            if (existing.getStock() == null) {
                existing.setStock(0);
            }
            existing.setStock(existing.getStock() + quantity);
            existing.setUpdatedAt(LocalDateTime.now());

            ProductEntity updated = productRepository.save(existing);
            return toDomain(updated);
        } catch (ProductNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Product decrementStock(Long id, int quantity) {
        try {
            ProductEntity existing = productRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);

            if (existing.getStock() == null) {
                existing.setStock(0);
            }
            int newStock = existing.getStock() - quantity;
            if (newStock < 0) {
                throw new IllegalArgumentException("Stock cannot be negative");
            }
            existing.setStock(newStock);
            existing.setUpdatedAt(LocalDateTime.now());

            ProductEntity updated = productRepository.save(existing);
            return toDomain(updated);
        } catch (ProductNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DataRepositoryAccessException();
        }
    }

    private Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getPrice(),
                entity.getStock(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .stock(product.getStock())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}