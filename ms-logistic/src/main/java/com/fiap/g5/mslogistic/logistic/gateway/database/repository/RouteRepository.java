package com.fiap.g5.mslogistic.logistic.gateway.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.g5.mslogistic.logistic.gateway.database.entity.RouteEntity;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    
}
