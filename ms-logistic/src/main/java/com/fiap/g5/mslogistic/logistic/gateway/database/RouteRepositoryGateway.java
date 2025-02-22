package com.fiap.g5.mslogistic.logistic.gateway.database;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fiap.g5.mslogistic.logistic.domain.CreateRoute;
import com.fiap.g5.mslogistic.logistic.domain.Route;
import com.fiap.g5.mslogistic.logistic.domain.RouteItem;
import com.fiap.g5.mslogistic.logistic.gateway.RouteGateway;
import com.fiap.g5.mslogistic.logistic.gateway.database.entity.RouteEntity;
import com.fiap.g5.mslogistic.logistic.gateway.database.entity.RouteItemEntity;
import com.fiap.g5.mslogistic.logistic.gateway.database.repository.RouteItemRepository;
import com.fiap.g5.mslogistic.logistic.gateway.database.repository.RouteRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class RouteRepositoryGateway implements RouteGateway {
    private RouteRepository routeRepository;
    private RouteItemRepository routeItemRepository;

    @Override
    public Route create(CreateRoute createRoute) {
        var routeEntity = RouteEntity.builder()
            .delivery(createRoute.getDelivery())
            .createdAt(LocalDateTime.now())
            .build();
        var savedRouteEntity = routeRepository.save(routeEntity);
        var routeItems = new ArrayList<RouteItemEntity>();
        for (var routeItem : createRoute.getRouteItems()) {
            var routeItemEntity = RouteItemEntity.builder()
                .logisticId(routeItem.getLogisticId())
                .number(routeItem.getNumber())
                .position(routeItem.getPosition())
                .routeId(savedRouteEntity.getId())
                .postcode(routeItem.getPostcode())
                .build();
            var currentRouteItemEntity = routeItemRepository.save(routeItemEntity);
            routeItems.add(currentRouteItemEntity);
        }
        return mapToDomain(savedRouteEntity, routeItems);
    }

    @Override
    public List<Route> findAll() {
        var routes = routeRepository.findAll();
        var routesDomain = new ArrayList<Route>();
        for (var route : routes) {
            var routeItems = routeItemRepository.findByRouteIdOrderByPositionAsc(route.getId());
            routesDomain.add(mapToDomain(route, routeItems));
        }
        return routesDomain;
    }

    @Override
    public Route findById(Long id) {
        var route = routeRepository.findById(id).orElse(null);
        if (route != null) {
            var routeItems = routeItemRepository.findByRouteIdOrderByPositionAsc(route.getId());
            return mapToDomain(route, routeItems);
        }
        return null;
    }

    private Route mapToDomain(RouteEntity routeEntity, List<RouteItemEntity> routeItems) {
        var route = new Route();
        route.setId(routeEntity.getId());
        route.setDelivery(routeEntity.getDelivery());
        route.setCreatedAt(routeEntity.getCreatedAt());
        var routeItemsDomain = new ArrayList<RouteItem>();
        for (var routeItemEntity : routeItems) {
            var routeItem = new RouteItem();
            routeItem.setId(routeItemEntity.getId());
            routeItem.setLogisticId(routeItemEntity.getLogisticId());
            routeItem.setPostcode(routeItemEntity.getPostcode());
            routeItem.setNumber(routeItemEntity.getNumber());
            routeItem.setPosition(routeItemEntity.getPosition());
            routeItem.setRouteId(routeItemEntity.getRouteId());
            routeItemsDomain.add(routeItem);
        }
        route.setRouteItems(routeItemsDomain);
        return route;
    }
}
