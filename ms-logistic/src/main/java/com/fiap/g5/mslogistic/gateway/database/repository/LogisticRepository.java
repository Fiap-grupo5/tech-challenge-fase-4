package com.fiap.g5.mslogistic.gateway.database.repository;

import com.fiap.g5.mslogistic.gateway.database.entity.LogisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticRepository extends JpaRepository<LogisticEntity, Long> {
}
