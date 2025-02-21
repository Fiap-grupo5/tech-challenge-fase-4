package com.fiap.g5.mslogistic.logistic.gateway.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fiap.g5.mslogistic.logistic.gateway.api.json.OrderJson;

@FeignClient(value = "ms-order")
public interface OrderFeignClient {
    @GetMapping("/order-service/order/{id}")
    OrderJson findById(@PathVariable(value = "id") Long id);

    @PostMapping("/order-service/order/{id}/status/{status}")
    OrderJson updateStatus(@PathVariable(value = "id") Long id, @PathVariable(value = "status") String status);
}
