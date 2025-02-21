package com.fiap.g5.msorder.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Order {
    private Long id;
    private Long customerId;
    private String status;
    private String postcode;
    private Integer number;
    private Double total;
}
