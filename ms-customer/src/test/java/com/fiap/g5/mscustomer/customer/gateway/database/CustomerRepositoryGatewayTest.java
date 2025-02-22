package com.fiap.g5.mscustomer.customer.gateway.database;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.domain.CustomerDTO;
import com.fiap.g5.mscustomer.customer.exception.AcessoRepositorioDadosException;
import com.fiap.g5.mscustomer.customer.gateway.database.entity.CustomerEntity;
import com.fiap.g5.mscustomer.customer.gateway.database.repository.CustomerRepository;

class CustomerRepositoryGatewayTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerRepositoryGateway customerGateway;

    private CustomerEntity customerEntity;
    private CustomerDTO customerDTO;
    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        customerEntity = CustomerEntity.builder()
                .id(1L)
                .name("Sirius Black")
                .email("Sirius@example.com")
                .phone("11889999999")
                .postcode("02000-000")
                .number(123L)
                .build();

        customerDTO = new CustomerDTO(
                "Sirius Black",
                "Sirius@example.com",
                "11889999999",
                "02000-000",
                123L
        );

        customer = new Customer(
        );
    }

    @Test
    void shouldFindCustomerById() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));

        Optional<Customer> foundCustomer = customerGateway.findById(1L);

        assertTrue(foundCustomer.isPresent());
        assertEquals(customer.getId(), foundCustomer.get().getId());
    }

    @Test
    void shouldThrowExceptionWhenCustomerNotFound() {
        when(customerRepository.findById(1L)).thenThrow(new RuntimeException());

        assertThrows(AcessoRepositorioDadosException.class, () -> customerGateway.findById(1L));
    }

    @Test
    void shouldCreateCustomerSuccessfully() {
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(customerEntity);

        Customer createdCustomer = customerGateway.create(customerDTO);

        assertNotNull(createdCustomer);
        assertEquals(customer.getName(), createdCustomer.getName());
    }

    @Test
    void shouldThrowExceptionWhenCreateFails() {
        when(customerRepository.save(any(CustomerEntity.class))).thenThrow(new RuntimeException());

        assertThrows(AcessoRepositorioDadosException.class, () -> customerGateway.create(customerDTO));
    }

    @Test
    void shouldFindAllCustomers() {
        when(customerRepository.findAll()).thenReturn(List.of(customerEntity));

        List<Customer> customers = customerGateway.findAll();

        assertFalse(customers.isEmpty());
        assertEquals(1, customers.size());
    }

    @Test
    void shouldReturnEmptyListWhenNoCustomers() {
        when(customerRepository.findAll()).thenReturn(List.of());

        List<Customer> customers = customerGateway.findAll();

        assertTrue(customers.isEmpty());
    }

    @Test
    void shouldDeleteCustomerSuccessfully() {
        assertDoesNotThrow(() -> customerGateway.delete(1L));
        verify(customerRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldThrowExceptionWhenDeleteFails() {
        doThrow(new RuntimeException()).when(customerRepository).deleteById(1L);

        assertThrows(AcessoRepositorioDadosException.class, () -> customerGateway.delete(1L));
    }

    @Test
    void shouldUpdateCustomerSuccessfully() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(customerEntity);

        Customer updatedCustomer = customerGateway.update(customerDTO, 1L);

        assertNotNull(updatedCustomer);
        assertEquals(customer.getEmail(), updatedCustomer.getEmail());
    }

    @Test
    void shouldThrowExceptionWhenUpdateFails() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));
        when(customerRepository.save(any(CustomerEntity.class))).thenThrow(new RuntimeException());

        assertThrows(AcessoRepositorioDadosException.class, () -> customerGateway.update(customerDTO, 1L));
    }
}
