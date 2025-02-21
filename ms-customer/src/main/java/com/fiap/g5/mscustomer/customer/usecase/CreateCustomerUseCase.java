package com.fiap.g5.mscustomer.customer.usecase;

import org.springframework.stereotype.Service;

import com.fiap.g5.mscustomer.customer.domain.CustomerDTO;
import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CreateCustomerUseCase {
    private CustomerGateway customerGateway;

    public Customer create(CustomerDTO createCustomer) {
        return customerGateway.create(createCustomer);
    }
}
