package com.fiap.g5.mscustomer.customer.gateway;

import java.util.List;
import java.util.Optional;

import com.fiap.g5.mscustomer.customer.domain.CustomerDTO;
import com.fiap.g5.mscustomer.customer.domain.Customer;

public interface CustomerGateway {
    Optional<Customer> findById(Long id);
    Customer create(CustomerDTO customer);
    List<Customer> findAll();
    void delete(Long id);
    Customer update(CustomerDTO customer, Long id);
}
