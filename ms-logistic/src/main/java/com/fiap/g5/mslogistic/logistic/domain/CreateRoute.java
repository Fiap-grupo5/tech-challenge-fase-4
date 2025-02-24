package com.fiap.g5.mslogistic.logistic.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CreateRoute {
    private String delivery;
    private List<CreateRouteItem> routeItems;
}
