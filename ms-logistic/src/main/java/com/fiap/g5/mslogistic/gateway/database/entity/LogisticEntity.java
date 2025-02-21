package com.fiap.g5.mslogistic.gateway.database.entity;

import com.fiap.g5.mslogistic.domain.LogisticStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logistics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogisticEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    private String delivery;

    @Enumerated(EnumType.STRING)
    private LogisticStatus status;

    @Column(name = "estimated_date")
    private LocalDateTime estimatedDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
