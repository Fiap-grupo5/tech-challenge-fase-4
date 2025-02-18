package com.fiap.g5.mscustomer.customer.usecase;

import org.springframework.stereotype.Service;

import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteCustomerUseCase {
    private CustomerGateway customerGateway;

    public void delete(Long id) {
        customerGateway.delete(id);
    }
}
