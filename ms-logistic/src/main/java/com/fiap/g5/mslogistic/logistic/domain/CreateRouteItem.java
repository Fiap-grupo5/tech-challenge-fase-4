package com.fiap.g5.mslogistic.logistic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CreateRouteItem {
    private String postcode;
    private Integer number;
    private Integer position;
    private Long logisticId;
}
