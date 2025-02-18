package com.fiap.g5.mscustomer.customer.gateway.database;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fiap.g5.mscustomer.customer.domain.CustomerDTO;
import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.exception.AcessoRepositorioDadosException;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;
import com.fiap.g5.mscustomer.customer.gateway.database.entity.CustomerEntity;
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

    @Override
    public Customer create(CustomerDTO customer) {
        try {
            CustomerEntity newCustomerEntity = CustomerEntity
                .builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .postcode(customer.getPostcode())
                .number(customer.getNumber())
                .build();
            CustomerEntity customerEntity = customerRepository.save(newCustomerEntity);
            return new Customer(customerEntity.getId(), customerEntity.getName(), customerEntity.getEmail(), customerEntity.getPhone(), customerEntity.getPostcode(), customerEntity.getNumber());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new AcessoRepositorioDadosException();
        }
    }

    @Override
    public List<Customer> findAll() {
        try {
            List<CustomerEntity> customerEntities = customerRepository.findAll();
            return customerEntities.stream().map(customerEntity -> new Customer(
                customerEntity.getId(),
                customerEntity.getName(),
                customerEntity.getEmail(),
                customerEntity.getPhone(),
                customerEntity.getPostcode(),
                customerEntity.getNumber())).toList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new AcessoRepositorioDadosException();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new AcessoRepositorioDadosException();
        }
    }

    @Override
    public Customer update(CustomerDTO customer, Long id) {
        try {
            CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow();
            customerEntity.setName(customer.getName());
            customerEntity.setEmail(customer.getEmail());
            customerEntity.setPhone(customer.getPhone());
            customerEntity.setPostcode(customer.getPostcode());
            customerEntity.setNumber(customer.getNumber());
            CustomerEntity updatedCustomerEntity = customerRepository.save(customerEntity);
            return new Customer(updatedCustomerEntity.getId(), updatedCustomerEntity.getName(), updatedCustomerEntity.getEmail(), updatedCustomerEntity.getPhone(), updatedCustomerEntity.getPostcode(), updatedCustomerEntity.getNumber());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new AcessoRepositorioDadosException();
        }
    }
}
