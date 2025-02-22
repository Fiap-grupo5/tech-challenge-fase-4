package com.fiap.g5.mslogistic.logistic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RouteItem {
    private Long id;

    private String postcode;

    private Integer number;

    private Integer position;

    private Long routeId;

    private Long logisticId;
}
