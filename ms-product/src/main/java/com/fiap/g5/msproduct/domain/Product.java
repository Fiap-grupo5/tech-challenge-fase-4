package com.fiap.g5.msproduct.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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
    private BigDecimal price;
    private Integer stock;

    public void incrementStock(int quantity) {
        if (this.stock == null) {
            this.stock = 0;
        }
        this.stock += quantity;
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
    }
}
