package com.fiap.g5.mslogistic.logistic.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    private Long id;

    private String delivery;

    private LocalDateTime createdAt;

    private List<RouteItem> routeItems;
}
