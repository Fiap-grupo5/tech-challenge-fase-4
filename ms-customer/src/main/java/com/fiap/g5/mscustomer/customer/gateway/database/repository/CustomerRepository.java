package com.fiap.g5.mscustomer.customer.gateway.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.g5.mscustomer.customer.gateway.database.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    
}
