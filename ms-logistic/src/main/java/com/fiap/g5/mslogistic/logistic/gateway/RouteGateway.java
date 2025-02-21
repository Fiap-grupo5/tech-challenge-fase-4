package com.fiap.g5.mslogistic.logistic.gateway;

import java.util.List;

import com.fiap.g5.mslogistic.logistic.domain.CreateRoute;
import com.fiap.g5.mslogistic.logistic.domain.Route;

public interface RouteGateway {
    Route create(CreateRoute createRoute);
    List<Route> findAll();
    Route findById(Long id);
}
