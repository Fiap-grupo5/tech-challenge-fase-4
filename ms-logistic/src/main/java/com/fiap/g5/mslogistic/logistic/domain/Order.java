package com.fiap.g5.mslogistic.logistic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Order {
    private Long id;
    private Long customerId;
    private String status;
    private Double total;
}
