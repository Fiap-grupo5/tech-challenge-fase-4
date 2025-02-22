package com.fiap.g5.mslogistic.logistic.gateway.api;

import org.springframework.stereotype.Component;

import com.fiap.g5.mslogistic.logistic.domain.Order;
import com.fiap.g5.mslogistic.logistic.exception.AcessoOrderServiceException;
import com.fiap.g5.mslogistic.logistic.gateway.OrderGateway;
import com.fiap.g5.mslogistic.logistic.gateway.api.feign.OrderFeignClient;
import com.fiap.g5.mslogistic.logistic.gateway.api.json.OrderJson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderApiServiceGateway implements OrderGateway {
    private final OrderFeignClient orderFeignClient;

    @Override
    public Order findById(Long id) {
        try {
            OrderJson orderJson = orderFeignClient.findById(id);
            return mapJsonToDomain(orderJson);
        } catch(Exception e) {
            log.error(e.getMessage(), e);
            throw new AcessoOrderServiceException();
        }
    }

    @Override
    public Order updateStatus(Long id, String status) {
        try {
            OrderJson orderJson = orderFeignClient.updateStatus(id, status);
            return mapJsonToDomain(orderJson);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new AcessoOrderServiceException();
        }
    }
    
    private Order mapJsonToDomain(OrderJson orderJson) {
		return new Order(orderJson.getId(), orderJson.getCustomerId(), orderJson.getStatus(), orderJson.getTotal());
	}
}
