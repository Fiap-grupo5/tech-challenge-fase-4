package com.fiap.g5.mslogistic.logistic.gateway.database.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fiap.g5.mslogistic.logistic.gateway.database.entity.LogisticEntity;

public interface LogisticRepository extends JpaRepository<LogisticEntity, Long> {
    
    @Query("SELECT l FROM LogisticEntity l " +
           "WHERE l.createdAt BETWEEN :start AND :end " +
           "AND l.status = :status " +
           "ORDER BY l.postcode ASC, l.number ASC")
    List<LogisticEntity> findLogisticsFromPeriodAndStatus(
        @Param("start") LocalDateTime start,
        @Param("end") LocalDateTime end,
        @Param("status") String status
    );
}
