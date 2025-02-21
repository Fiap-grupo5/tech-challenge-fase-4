package com.fiap.g5.msgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationRouter {
    
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            // .route("customer-service-route", r -> r.path("/customer-service/**").uri("lb://MS-CUSTOMER"))
            // .route("product-service-route", r -> r.path("/product-service/**").uri("lb://MS-PRODUCT"))
            .route("order-service-route", r -> r.path("/order-service/**").uri("lb://MS-ORDER"))
            .route("logistic-service-route", r -> r.path("/logistic-service/**").uri("lb://MS-LOGISTIC"))
            .build();
    }
}
