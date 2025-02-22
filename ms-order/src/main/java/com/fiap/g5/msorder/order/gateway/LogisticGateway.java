package com.fiap.g5.msorder.order.gateway;

import com.fiap.g5.msorder.order.domain.CreateLogistic;
import com.fiap.g5.msorder.order.domain.Logistic;

public interface LogisticGateway {
    Logistic create(CreateLogistic createLogistic);
}
