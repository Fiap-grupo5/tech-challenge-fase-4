package com.fiap.g5.mscustomer.customer.gateway;

import java.util.Optional;

import com.fiap.g5.mscustomer.customer.domain.Customer;

public interface CustomerGateway {
    Optional<Customer> findById(Long id);
}
