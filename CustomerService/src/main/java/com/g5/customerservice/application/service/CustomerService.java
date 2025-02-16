package com.g5.customerservice.application.service;

import com.g5.customerservice.domain.model.Customer;
import com.g5.customerservice.domain.port.CustomerRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepositoryPort customerRepositoryPort;

    public CustomerService(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepositoryPort.save(customer);
    }

    public Optional<Customer> getCustomerById(UUID id) {
        return customerRepositoryPort.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepositoryPort.findAll();
    }

    public void deleteCustomer(UUID id) {
        customerRepositoryPort.deleteById(id);
    }
}
