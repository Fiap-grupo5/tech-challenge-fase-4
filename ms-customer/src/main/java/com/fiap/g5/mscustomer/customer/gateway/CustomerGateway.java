package com.fiap.g5.mscustomer.customer.gateway;

import java.util.List;
import java.util.Optional;

import com.fiap.g5.mscustomer.customer.domain.CreateCustomer;
import com.fiap.g5.mscustomer.customer.domain.Customer;

public interface CustomerGateway {
    Optional<Customer> findById(Long id);
    Customer create(CreateCustomer customer);
    List<Customer> findAll();
    void delete(Long id);
}
