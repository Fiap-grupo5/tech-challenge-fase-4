package com.g5.customerservice.infrastructure.adapter.controller;

import com.g5.customerservice.application.service.CustomerService;
import com.g5.customerservice.domain.model.Customer;
import com.g5.customerservice.domain.port.CustomerRepositoryPort;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer", description = "Gerenciamento de Clientes")
public class CustomerController {

    private final CustomerService customerService;
    private CustomerRepositoryPort customerRepository;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @Operation(summary = "Criação de um novo cliente", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Detalhes do novo cliente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Customer.class),
                    examples = @ExampleObject(
                            name = "Exemplo de Cliente",
                            value =  "{\n" +
                                    "  \"name\": \"Kennia Sobrinho\",\n" +
                                    "  \"email\": \"testando@gmail.com\",\n" +
                                    "  \"phone\": \"(61) 99999-9999\",\n" +
                                    "  \"address\": \"Rua do Teste, nº 5\",\n" +
                                    "  \"createdAt\": \"2021-09-01T00:00:00\"\n" +
                                    "}"
                    )
            )
    ))
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setId(UUID.randomUUID());
        return customerRepository.save(customer);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter um cliente por ID")
    public Optional<Customer> getCustomer(@PathVariable UUID id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    @Operation(summary = "Obter todos os clientes")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um cliente por ID")
    public void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
    }
}
