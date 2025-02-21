package com.fiap.g5.mslogistic.logistic.gateway.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.g5.mslogistic.logistic.gateway.database.entity.LogisticEntity;

public interface LogisticRepository extends JpaRepository<LogisticEntity, Long> {
    
}
