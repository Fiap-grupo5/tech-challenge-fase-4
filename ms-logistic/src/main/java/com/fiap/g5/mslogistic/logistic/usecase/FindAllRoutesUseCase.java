package com.fiap.g5.mslogistic.logistic.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.Route;
import com.fiap.g5.mslogistic.logistic.gateway.RouteGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindAllRoutesUseCase {
    private RouteGateway routeGateway;

    public List<Route> findAll() {
        return routeGateway.findAll();
    }
}
