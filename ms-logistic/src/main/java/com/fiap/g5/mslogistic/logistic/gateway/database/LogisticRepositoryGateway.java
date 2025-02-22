package com.fiap.g5.mslogistic.logistic.gateway.database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fiap.g5.mslogistic.logistic.domain.CreateLogistic;
import com.fiap.g5.mslogistic.logistic.domain.Logistic;
import com.fiap.g5.mslogistic.logistic.domain.LogisticStatus;
import com.fiap.g5.mslogistic.logistic.gateway.LogisticGateway;
import com.fiap.g5.mslogistic.logistic.gateway.database.entity.LogisticEntity;
import com.fiap.g5.mslogistic.logistic.gateway.database.repository.LogisticRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class LogisticRepositoryGateway implements LogisticGateway {
    private final LogisticRepository logisticRepository;

    @Override
    public Logistic create(CreateLogistic createLogistic) {
        LogisticEntity logisticEntity = LogisticEntity.builder()
            .delivery(null)
            .deliveryDate(null)
            .estimatedDate(LocalDateTime.now().plusDays(3)) // ? 3 days after create
            .status(LogisticStatus.PENDING.getStatus())
            .orderId(createLogistic.getOrderId())
            .postcode(createLogistic.getPostcode())
            .number(createLogistic.getNumber())
            .createdAt(LocalDateTime.now())
            .build();
        logisticRepository.save(logisticEntity);
        return toDomain(logisticEntity);
    }

    @Override
    public Logistic findById(Long id) {
        LogisticEntity logisticEntity = logisticRepository.findById(id).orElse(null);
        if (logisticEntity == null) {
            return null;
        }
        return toDomain(logisticEntity);
    }

    @Override
    public Logistic updateDelivery(Long id, String delivery) {
        LogisticEntity logisticEntity = logisticRepository.findById(id).orElse(null);
        if (logisticEntity == null) {
            return null;
        }
        logisticEntity.setDelivery(delivery);
        logisticRepository.save(logisticEntity);
        return toDomain(logisticEntity);
    }

    @Override
    public Logistic updateDeliveryDate(Long id, LocalDateTime deliveryDate) {
        LogisticEntity logisticEntity = logisticRepository.findById(id).orElse(null);
        if (logisticEntity == null) {
            return null;
        }
        logisticEntity.setDeliveryDate(deliveryDate);
        logisticRepository.save(logisticEntity);
        return toDomain(logisticEntity);
    }

    @Override
    public Logistic updateStatus(Long id, String status) {
        LogisticEntity logisticEntity = logisticRepository.findById(id).orElse(null);
        if (logisticEntity == null) {
            return null;
        }
        logisticEntity.setStatus(status);
        logisticRepository.save(logisticEntity);
        return toDomain(logisticEntity);
    }

    @Override
    public List<Logistic> findAll() {
        var logisticEntities = logisticRepository.findAll();
        return logisticEntities.stream().map(this::toDomain).toList();
    }
    
    @Override
    public List<Logistic> findTaskPayload() {
        LocalDateTime startOfYesterday = LocalDate.now().minusDays(1).atStartOfDay();
        LocalDateTime endOfYesterday = startOfYesterday.plusDays(1).minusNanos(1);
        var logisticEntities = logisticRepository.findLogisticsFromPeriodAndStatus(startOfYesterday, endOfYesterday, LogisticStatus.PENDING.getStatus());
        return logisticEntities.stream().map(this::toDomain).toList();
    }

    private Logistic toDomain(LogisticEntity logisticEntity) {
        return new Logistic(
            logisticEntity.getId(),
            logisticEntity.getOrderId(),
            logisticEntity.getPostcode(),
            logisticEntity.getNumber(),
            logisticEntity.getStatus(),
            logisticEntity.getDelivery(),
            logisticEntity.getEstimatedDate(),
            logisticEntity.getDeliveryDate(),
            logisticEntity.getCreatedAt()
        );
    }

}
