package com.fiap.g5.mslogistic.gateway.database;

import com.fiap.g5.mslogistic.domain.Logistic;
import com.fiap.g5.mslogistic.exception.LogisticNotFoundException;
import com.fiap.g5.mslogistic.gateway.LogisticGateway;
import com.fiap.g5.mslogistic.gateway.database.entity.LogisticEntity;
import com.fiap.g5.mslogistic.gateway.database.repository.LogisticRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LogisticRepositoryGateway implements LogisticGateway {

    private final LogisticRepository logisticRepository;

    @Override
    public List<Logistic> findAll() {
        return logisticRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Logistic> findById(Long id) {
        return logisticRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Logistic create(Logistic logistic) {
        LogisticEntity entity = toEntity(logistic);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        LogisticEntity saved = logisticRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Logistic update(Long id, Logistic logistic) {
        LogisticEntity existing = logisticRepository.findById(id)
                .orElseThrow(LogisticNotFoundException::new);

        existing.setDelivery(logistic.getDelivery());
        existing.setStatus(logistic.getStatus());
        existing.setEstimatedDate(logistic.getEstimatedDate());
        existing.setDeliveryDate(logistic.getDeliveryDate());
        existing.setUpdatedAt(LocalDateTime.now());

        LogisticEntity updated = logisticRepository.save(existing);
        return toDomain(updated);
    }

    @Override
    public void delete(Long id) {
        logisticRepository.deleteById(id);
    }

    private Logistic toDomain(LogisticEntity entity) {
        return new Logistic(
                entity.getId(),
                entity.getOrderId(),
                entity.getDelivery(),
                entity.getStatus(),
                entity.getEstimatedDate(),
                entity.getDeliveryDate(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private LogisticEntity toEntity(Logistic logistic) {
        return LogisticEntity.builder()
                .id(logistic.getId())
                .orderId(logistic.getOrderId())
                .delivery(logistic.getDelivery())
                .status(logistic.getStatus())
                .estimatedDate(logistic.getEstimatedDate())
                .deliveryDate(logistic.getDeliveryDate())
                .createdAt(logistic.getCreatedAt())
                .updatedAt(logistic.getUpdatedAt())
                .build();
    }
}
