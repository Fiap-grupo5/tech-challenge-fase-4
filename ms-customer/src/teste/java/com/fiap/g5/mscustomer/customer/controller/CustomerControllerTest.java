package com.fiap.g5.mscustomer.customer.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.g5.mscustomer.customer.controller.json.CustomerJson;
import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.domain.CustomerDTO;
import com.fiap.g5.mscustomer.customer.usecase.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FindCustomerUseCase findCustomerUseCase;

    @Mock
    private CreateCustomerUseCase createCustomerUseCase;

    @Mock
    private FindAllCustomerUseCase findAllCustomerUseCase;

    @Mock
    private DeleteCustomerUseCase deleteCustomerUseCase;

    @Mock
    private UpdateCustomerUseCase updateCustomerUseCase;

    @InjectMocks
    private CustomerController customerController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void shouldReturnAllCustomers() throws Exception {
        Customer customer = new Customer(UUID.randomUUID(), "Filipe Luis", "Filipinho@example.com", "123456789", "Rua ErreJota, 2019");
        when(findAllCustomerUseCase.findAll()).thenReturn(List.of(customer));

        mockMvc.perform(get("/customer/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Filipe Luis"));
    }

    @Test
    void shouldReturnCustomerById() throws Exception {
        UUID id = UUID.randomUUID();
        Customer customer = new Customer(id, "Arrascaeta", "arrasca@example.com", "123456789", "Rua RJ, 123");
        when(findCustomerUseCase.findById(id)).thenReturn(customer);

        mockMvc.perform(get("/customer/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Arrascaeta"));
    }

    @Test
    void shouldCreateCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO("Everton Ribeiro", "er7@example.com", "123456789", "Rua RJ, 2024");
        Customer customer = new Customer(UUID.randomUUID(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getPhone(), customerDTO.getAddress());

        when(createCustomerUseCase.create(any(CustomerDTO.class))).thenReturn(customer);

        mockMvc.perform(post("/customer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Everton Ribeiro"));
    }

    @Test
    void shouldUpdateCustomer() throws Exception {
        UUID id = UUID.randomUUID();''
        CustomerDTO customerDTO = new CustomerDTO("Everton Update", "updated@example.com", "987654321", "Rua BA, 2025");
        Customer updatedCustomer = new Customer(id, customerDTO.getName(), customerDTO.getEmail(), customerDTO.getPhone(), customerDTO.getAddress());

        when(updateCustomerUseCase.update(any(CustomerDTO.class), eq(id))).thenReturn(updatedCustomer);

        mockMvc.perform(put("/customer/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Everton Update"));
    }

    @Test
    void shouldDeleteCustomer() throws Exception {
        UUID id = UUID.randomUUID();
        doNothing().when(deleteCustomerUseCase).delete(id);

        mockMvc.perform(delete("/customer/{id}", id))
                .andExpect(status().isNoContent());
    }
}
