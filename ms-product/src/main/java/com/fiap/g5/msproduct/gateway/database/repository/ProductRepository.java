package com.fiap.g5.msproduct.gateway.database.repository;

import com.fiap.g5.msproduct.gateway.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
