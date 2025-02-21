package com.fiap.g5.mscustomer.customer.usecase;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.domain.CustomerDTO;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

@ExtendWith(MockitoExtension.class)
class CreateCustomerUseCaseTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private CreateCustomerUseCase createCustomerUseCase;

    private CustomerDTO customerDTO;
    private Customer customer;

    @BeforeEach
    void setup() {
        customerDTO = new CustomerDTO("Levi Ackerman", "levi@example.com", "123456789", "Rua SNK", 123L);
        customer = new Customer();;
    }

    @Test
    void shouldCreateCustomerSuccessfully() {
        when(customerGateway.create(customerDTO)).thenReturn(customer);

        Customer createdCustomer = createCustomerUseCase.create(customerDTO);

        assertNotNull(createdCustomer);
        assertEquals(customer.getId(), createdCustomer.getId());
        assertEquals(customer.getName(), createdCustomer.getName());
        assertEquals(customer.getEmail(), createdCustomer.getEmail());
        verify(customerGateway, times(1)).create(customerDTO);
    }
}
