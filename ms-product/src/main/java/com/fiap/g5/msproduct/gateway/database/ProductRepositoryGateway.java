package com.fiap.g5.msproduct.gateway.database;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.exception.DataRepositoryAccessException;
import com.fiap.g5.msproduct.exception.ProductNotFoundException;
import com.fiap.g5.msproduct.gateway.ProductGateway;
import com.fiap.g5.msproduct.gateway.database.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
            return productRepository.findAll();
        } catch (Exception e) {
            log.error("Erro ao buscar todos os produtos", e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        try {
            return productRepository.findById(id);
        } catch (Exception e) {
            log.error("Erro ao buscar produto por id", e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Product create(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            log.error("Erro ao criar produto", e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Product update(Long id, Product product) {
        try {
            Product existing = productRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);

            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setStock(product.getStock());

            return productRepository.save(existing);

        } catch (ProductNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Erro ao atualizar produto", e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Erro ao deletar produto", e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Product incrementStock(Long id, int quantity) {
        try {
            Product existing = productRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);

            existing.incrementStock(quantity);
            return productRepository.save(existing);

        } catch (ProductNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Erro ao incrementar estoque", e);
            throw new DataRepositoryAccessException();
        }
    }

    @Override
    public Product decrementStock(Long id, int quantity) {
        try {
            Product existing = productRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);

            existing.decrementStock(quantity);
            return productRepository.save(existing);

        } catch (ProductNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Erro ao decrementar estoque", e);
            throw new DataRepositoryAccessException();
        }
    }
}
