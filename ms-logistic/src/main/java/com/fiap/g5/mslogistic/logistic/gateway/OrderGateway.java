package com.fiap.g5.mslogistic.logistic.gateway;

import com.fiap.g5.mslogistic.logistic.domain.Order;

public interface OrderGateway {
    Order findById(Long id);
    Order updateStatus(Long id, String status);
}
