package com.fiap.g5.mscustomer.customer.gateway.database;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.exception.AcessoRepositorioDadosException;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;
import com.fiap.g5.mscustomer.customer.gateway.database.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@AllArgsConstructor
public class CustomerRepositoryGateway implements CustomerGateway {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> findById(Long id) {
        try {
            return customerRepository.findById(id).map(customerEntity -> new Customer(
                customerEntity.getId(),
                customerEntity.getName(),
                customerEntity.getEmail(),
                customerEntity.getPhone(),
                customerEntity.getPostcode(),
                customerEntity.getNumber()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
			throw new AcessoRepositorioDadosException();
        }
    }
}
