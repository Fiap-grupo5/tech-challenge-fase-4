package com.g5.customerservice.domain.port;

import com.g5.customerservice.domain.model.Customer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepositoryPort {
    Customer save(Customer customer);
    Optional<Customer> findById(UUID id);
    List<Customer> findAll();
    void deleteById(UUID id);
}
