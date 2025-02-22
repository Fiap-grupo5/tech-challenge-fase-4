package com.fiap.g5.msorder.order.domain;

import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {

    private Long id;
    private Long customerId;
    private OrderStatus status; 
    private String postcode;        
    private int number;      
    private double total; 
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<OrderItem> items = new ArrayList<>();

    public Order(Long id, Long customerId, String status, String postcode, int number, double total) {
        this.id = id;
        this.customerId = customerId;
        // Converte a String para enum
        this.status = OrderStatus.valueOf(status.toUpperCase());
        this.postcode = postcode;
        this.number = number;
        this.total = total;
    }

    public Order(Long id, Long customerId, OrderStatus status, String postcode, int number, double total,
                 LocalDateTime createdAt, LocalDateTime updatedAt, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.postcode = postcode;
        this.number = number;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        if (items != null) {
            this.items = items;
        }
    }
}
