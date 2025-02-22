package com.fiap.g5.mslogistic.logistic.gateway.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.g5.mslogistic.logistic.gateway.database.entity.RouteItemEntity;
import java.util.List;


public interface RouteItemRepository extends JpaRepository<RouteItemEntity, Long> {
    List<RouteItemEntity> findByRouteIdOrderByPositionAsc(Long routeId);
}
