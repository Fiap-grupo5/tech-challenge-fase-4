package com.g5.customerservice.infrastructure.adapter.repository;

import com.g5.customerservice.domain.model.Customer;
import com.g5.customerservice.domain.port.CustomerRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID>, CustomerRepositoryPort {}
