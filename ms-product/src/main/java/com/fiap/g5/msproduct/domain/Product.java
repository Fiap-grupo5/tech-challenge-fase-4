package com.fiap.g5.msproduct.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product incrementStock(int quantity) {
        if (stock == null) {
            stock = 0;
        }
        stock += quantity;
        return this;
    }

    public Product decrementStock(int quantity) {
        if (stock == null) {
            stock = 0;
        }
        int newStock = stock - quantity;
        if (newStock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        stock = newStock;
        return this;
    }
}
