package com.fiap.g5.mscustomer.customer.usecase;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

class DeleteCustomerUseCaseTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private DeleteCustomerUseCase deleteCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDeleteCustomerById() {
        Long id = 1L;

        deleteCustomerUseCase.delete(id);

        verify(customerGateway, times(1)).delete(id);
    }
}
