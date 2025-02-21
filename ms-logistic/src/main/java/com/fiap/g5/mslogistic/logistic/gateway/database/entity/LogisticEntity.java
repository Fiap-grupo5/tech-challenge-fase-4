package com.fiap.g5.mslogistic.logistic.gateway.database.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "logistic")
public class LogisticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    private String postcode;

    private Integer number;

    private String status;
    
    @Column(nullable = true)
    private String delivery;
    
    @Column(name = "estimated_date", nullable = false)
    private LocalDateTime estimatedDate;
    
    @Column(name = "delivery_date", nullable = true)
    private LocalDateTime deliveryDate;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
