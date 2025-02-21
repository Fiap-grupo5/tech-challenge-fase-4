package com.fiap.g5.msorder.order.gateway.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.g5.msorder.order.domain.CreateLogistic;
import com.fiap.g5.msorder.order.domain.Logistic;
import com.fiap.g5.msorder.order.gateway.LogisticGateway;
import com.fiap.g5.msorder.order.gateway.api.feign.LogisticFeignClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class LogisticApiServiceGateway implements LogisticGateway {
    @Autowired
    private LogisticFeignClient logisticFeignClient;
    @Override
    public Logistic create(CreateLogistic createLogistic) {
        return logisticFeignClient.create(createLogistic);
    }
}
