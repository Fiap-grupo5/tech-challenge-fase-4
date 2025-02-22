package com.fiap.g5.msorder.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CreateLogistic {
    private String postcode;
    private Integer number;
    private Long orderId;
}
