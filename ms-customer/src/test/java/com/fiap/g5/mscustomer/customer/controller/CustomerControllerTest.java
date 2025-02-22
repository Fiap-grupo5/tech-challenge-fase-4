package com.fiap.g5.mscustomer.customer.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.domain.CustomerDTO;
import com.fiap.g5.mscustomer.customer.usecase.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private FindCustomerUseCase findCustomerUseCase;

    @MockBean
    private CreateCustomerUseCase createCustomerUseCase;

    @MockBean
    private FindAllCustomerUseCase findAllCustomerUseCase;

    @MockBean
    private DeleteCustomerUseCase deleteCustomerUseCase;

    @MockBean
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
        Customer customer = new Customer();
        customer.setName("Filipe Luis");
        when(findAllCustomerUseCase.findAll()).thenReturn(List.of(customer));


        mockMvc.perform(get("/customer/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Filipe Luis"));
    }

    @Test
    void shouldReturnCustomerById() throws Exception {
        Long id = 1L;
        Customer customer = new Customer();
        customer.setName("Arrascaeta");
        when(findCustomerUseCase.findById(id)).thenReturn(customer);


        mockMvc.perform(get("/customer/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Arrascaeta"));
    }

    @Test
    void shouldCreateCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO("Everton Ribeiro", "er7@example.com", "123456789", "Rua RJ", 2024L);

        Customer customer = new Customer();
        customer.setName("Everton Ribeiro");

        when(createCustomerUseCase.create(any(CustomerDTO.class))).thenReturn(customer);

        mockMvc.perform(post("/customer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Everton Ribeiro"));
    }


    @Test
    void shouldUpdateCustomer() throws Exception {
        Long id = 1L;

        CustomerDTO customerDTO = new CustomerDTO("Everton Update", "updated@example.com", "987654321", "Rua BA", 2025L);

        Customer updatedCustomer = new Customer();
        updatedCustomer.setName("Everton Update");

        when(updateCustomerUseCase.update(any(CustomerDTO.class), eq(id))).thenReturn(updatedCustomer);

        mockMvc.perform(put("/customer/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Everton Update"));
    }


    @Test
    void shouldDeleteCustomer() throws Exception {
        Long id = 1L;
        doNothing().when(deleteCustomerUseCase).delete(id);

        mockMvc.perform(delete("/customer/{id}", id))
                .andExpect(status().isNoContent());
    }
}
