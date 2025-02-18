package com.fiap.g5.mscustomer.customer.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class FindAllCustomerUseCase {
    private CustomerGateway customerGateway;

    public List<Customer> findAll() {
        return customerGateway.findAll();
    }
}
