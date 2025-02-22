package com.fiap.g5.msorder.order.domain;

import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
        this.status = OrderStatus.valueOf(status.toUpperCase());
        this.postcode = postcode;
        this.number = number;
        this.total = total;
    }
}
