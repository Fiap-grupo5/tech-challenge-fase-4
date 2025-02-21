package com.fiap.g5.mscustomer.customer.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

class FindAllCustomerUseCaseTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private FindAllCustomerUseCase findAllCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllCustomers() {
        Customer customer1 = new Customer(1L, "Itadori Yuji", "Itadori@example.com", "123456789", "Jujutsu", 2022L);
        Customer customer2 = new Customer(2L, "Sirius Black", "sirius@example.com", "987654321", "HarryPotter", 2023L);
        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerGateway.findAll()).thenReturn(customers);

        List<Customer> result = findAllCustomerUseCase.findAll();

        assertEquals(2, result.size());
        assertEquals("Itadori Yuji", result.get(0).getName());
        assertEquals("Sirius Black", result.get(1).getName());
        verify(customerGateway, times(1)).findAll();
    }
}
