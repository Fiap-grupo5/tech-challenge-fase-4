package com.fiap.g5.mslogistic.logistic.gateway.api.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class OrderJson {
    private Long id;
    private Long customerId;
    private String status;
    private Double total;
}
