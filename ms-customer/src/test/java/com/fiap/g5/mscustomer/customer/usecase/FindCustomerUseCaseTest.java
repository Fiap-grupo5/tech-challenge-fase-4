package com.fiap.g5.mscustomer.customer.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.exception.CustomerNaoEncontradoException;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

import java.util.Optional;

class FindCustomerUseCaseTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private FindCustomerUseCase findCustomerUseCase;

    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        customer = new Customer(
                1L,
                "Levi Ackerman",
                "levi@example.com",
                "11999999999",
                "01000-000",
                123L
        );
    }

    @Test
    void shouldFindCustomerByIdSuccessfully() {
        when(customerGateway.findById(1L)).thenReturn(Optional.of(customer));

        Customer foundCustomer = findCustomerUseCase.findById(1L);

        assertNotNull(foundCustomer);
        assertEquals(customer.getId(), foundCustomer.getId());
        assertEquals(customer.getName(), foundCustomer.getName());
    }

    @Test
    void shouldThrowExceptionWhenCustomerNotFound() {
        when(customerGateway.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CustomerNaoEncontradoException.class, () -> findCustomerUseCase.findById(1L));
    }
}
