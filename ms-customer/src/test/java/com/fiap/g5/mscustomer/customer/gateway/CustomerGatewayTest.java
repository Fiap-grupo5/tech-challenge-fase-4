package com.fiap.g5.mscustomer.customer.gateway;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.domain.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerGatewayTest {

    private CustomerGateway customerGateway;

    @BeforeEach
    void setUp() {
        customerGateway = mock(CustomerGateway.class);
    }

    @Test
    void testFindById() {
        Customer customer = new Customer(1L, "Ada Lovelace", "ada@example.com", "11999999999", "12345-678", 100L);
        when(customerGateway.findById(1L)).thenReturn(Optional.of(customer));

        Optional<Customer> foundCustomer = customerGateway.findById(1L);

        assertTrue(foundCustomer.isPresent());
        assertEquals(1L, foundCustomer.get().getId());
        assertEquals("Ada Lovelace", foundCustomer.get().getName());
        verify(customerGateway, times(1)).findById(1L);
    }

    @Test
    void testCreate() {
        CustomerDTO customerDTO = new CustomerDTO("Agatha Christie", "agatha@example.com", "11988887777", "54321-000", 200L);
        Customer customer = new Customer(2L, "Agatha Christie", "agatha@example.com", "11988887777", "54321-000", 200L);
        when(customerGateway.create(customerDTO)).thenReturn(customer);

        Customer createdCustomer = customerGateway.create(customerDTO);

        assertNotNull(createdCustomer);
        assertEquals(2L, createdCustomer.getId());
        verify(customerGateway, times(1)).create(customerDTO);
    }

    @Test
    void testFindAll() {
        List<Customer> customers = Arrays.asList(
                new Customer(1L, "Ada Lovelace", "ada@example.com", "11999999999", "12345-678", 100L),
                new Customer(2L, "Agatha Christie", "agatha@example.com", "11988887777", "54321-000", 200L)
        );
        when(customerGateway.findAll()).thenReturn(customers);

        List<Customer> result = customerGateway.findAll();

        assertEquals(2, result.size());
        verify(customerGateway, times(1)).findAll();
    }

    @Test
    void testDelete() {
        doNothing().when(customerGateway).delete(1L);

        customerGateway.delete(1L);

        verify(customerGateway, times(1)).delete(1L);
    }

    @Test
    void testUpdate() {
        CustomerDTO customerDTO = new CustomerDTO("Papa Francisco", "chico@example.com", "11977776666", "11111-222", 300L);
        Customer updatedCustomer = new Customer(3L, "Papa Francisco", "chico@example.com", "11977776666", "11111-222", 300L);
        when(customerGateway.update(customerDTO, 3L)).thenReturn(updatedCustomer);

        Customer result = customerGateway.update(customerDTO, 3L);

        assertNotNull(result);
        assertEquals("Papa Francisco", result.getName());
        verify(customerGateway, times(1)).update(customerDTO, 3L);
    }
}
