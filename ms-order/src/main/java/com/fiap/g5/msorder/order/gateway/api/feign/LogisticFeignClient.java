package com.fiap.g5.msorder.order.gateway.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.fiap.g5.msorder.order.domain.CreateLogistic;
import com.fiap.g5.msorder.order.domain.Logistic;

@FeignClient(name = "ms-logistic")
public interface LogisticFeignClient {

    @PostMapping("/logistic-service/logistic/")
    Logistic create(@RequestBody CreateLogistic createLogistic);
}
