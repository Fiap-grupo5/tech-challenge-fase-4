package com.g5.customerservice.infrastructure.config;

import com.g5.customerservice.domain.port.CustomerRepositoryPort;
import com.g5.customerservice.application.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CustomerService customerService(CustomerRepositoryPort customerRepositoryPort) {
        return new CustomerService(customerRepositoryPort);
    }
}
