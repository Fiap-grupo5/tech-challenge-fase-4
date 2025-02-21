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
        Customer customer1 = new Customer();
        customer1.setName("Itadori Yuji");

        Customer customer2 = new Customer();
        customer2.setName("Sirius Black");

        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerGateway.findAll()).thenReturn(customers);

        List<Customer> result = findAllCustomerUseCase.findAll();

        assertEquals(2, result.size());
        assertEquals("Itadori Yuji", result.get(0).getName());
        assertEquals("Sirius Black", result.get(1).getName());
        verify(customerGateway, times(1)).findAll();
    }

}
