package com.fiap.g5.mscustomer.customer.usecase;

import org.springframework.stereotype.Service;

import com.fiap.g5.mscustomer.customer.domain.CreateCustomer;
import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CreateCustomerUseCase {
    private CustomerGateway customerGateway;

    public Customer create(CreateCustomer createCustomer) {
        return customerGateway.create(createCustomer);
    }
}
