package com.fiap.g5.mslogistic.logistic.gateway.database.entity;

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
@Table(name = "route_item")
public class RouteItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postcode;

    private Integer number;

    private Integer position;

    @Column(name = "route_id", nullable = false)
    private Long routeId;

    @Column(name = "logistic_id", nullable = false)
    private Long logisticId;
}
