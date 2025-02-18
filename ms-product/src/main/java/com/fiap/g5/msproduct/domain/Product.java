package com.fiap.g5.msproduct.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void incrementStock(int quantity) {
        if (this.stock == null) {
            this.stock = 0;
        }
        this.stock += quantity;
        this.updatedAt = LocalDateTime.now();
    }

    public void decrementStock(int quantity) {
        if (this.stock == null) {
            this.stock = 0;
        }
        int newStock = this.stock - quantity;
        if (newStock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = newStock;
        this.updatedAt = LocalDateTime.now();
    }
}
