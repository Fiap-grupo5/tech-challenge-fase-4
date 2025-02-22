package com.fiap.g5.mslogistic.logistic.usecase;

import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.Route;
import com.fiap.g5.mslogistic.logistic.gateway.RouteGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindRouteByIdUseCase {
    private RouteGateway routeGateway;

    public Route findById(Long id) {
        return routeGateway.findById(id);
    }
}
