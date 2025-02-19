package com.fiap.g5.mscustomer.customer.usecase;

import org.springframework.stereotype.Service;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.exception.CustomerNaoEncontradoException;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class FindCustomerUseCase {
    private CustomerGateway customerGateway;

    public Customer findById(Long id) {
        return customerGateway.findById(id)
				.orElseThrow(() -> {
					log.warn("Customer não encontrado pelo id: {}", id);
					return new CustomerNaoEncontradoException();
				});
    }
}
