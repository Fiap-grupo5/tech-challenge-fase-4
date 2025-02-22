package com.fiap.g5.mscustomer.customer.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.domain.CustomerDTO;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;

class UpdateCustomerUseCaseTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private UpdateCustomerUseCase updateCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldUpdateCustomerSuccessfully() {
        Long id = 1L;
        CustomerDTO customerDTO = new CustomerDTO("Mikasa Ackerman", "mikasa@example.com", "987654321", "snk2", 123L);
        Customer updatedCustomer = new Customer();
        updatedCustomer.setName("Mikasa Ackerman");
        updatedCustomer.setEmail("mikasa@example.com");
        updatedCustomer.setPhone("987654321");
        updatedCustomer.setPostcode("snk2");
        updatedCustomer.setNumber(123L);

        when(customerGateway.update(customerDTO, id)).thenReturn(updatedCustomer);

        Customer result = updateCustomerUseCase.update(customerDTO, id);

        assertNotNull(result);
        assertEquals("Mikasa Ackerman", result.getName());
        assertEquals("mikasa@example.com", result.getEmail());
        assertEquals("987654321", result.getPhone());
        assertEquals("snk2", result.getPostcode());
        assertEquals(123L, result.getNumber());

        verify(customerGateway, times(1)).update(customerDTO, id);
    }

}
