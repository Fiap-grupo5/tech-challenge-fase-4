package com.fiap.g5.mslogistic.logistic.usecase;

import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.CreateRoute;
import com.fiap.g5.mslogistic.logistic.domain.Route;
import com.fiap.g5.mslogistic.logistic.gateway.RouteGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateRouteUseCase {
    private RouteGateway routeGateway;

    public Route create(CreateRoute createRoute) {
        return routeGateway.create(createRoute);
    }
}
