package com.fiap.g5.mscustomer.customer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.g5.mscustomer.customer.controller.json.CreateCustomerJson;
import com.fiap.g5.mscustomer.customer.controller.json.CustomerJson;
import com.fiap.g5.mscustomer.customer.domain.CreateCustomer;
import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.usecase.CreateCustomerUseCase;
import com.fiap.g5.mscustomer.customer.usecase.FindCustomerUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j
@CrossOrigin(origins = "*") //NOSONAR
@RequestMapping("/customer")
@RestController
@AllArgsConstructor
public class CustomerController {
    private FindCustomerUseCase findCustomerUseCase;
    private CreateCustomerUseCase createCustomerUseCase;

    @GetMapping("/{id}")
    public CustomerJson findCustomerById(@PathVariable("id") Long id) {
        Customer customer = findCustomerUseCase.findById(id);
        return new CustomerJson(customer);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerJson createCustomer(@RequestBody(required = true) CreateCustomerJson createCustomerJson) {
        CreateCustomer createCustomer = mapJsonToDomain(createCustomerJson);
        Customer customer = createCustomerUseCase.create(createCustomer);
        return new CustomerJson(customer);
    }
    
    private CreateCustomer mapJsonToDomain(CreateCustomerJson createCustomerJson) {
        return new CreateCustomer(
            createCustomerJson.getName(),
            createCustomerJson.getEmail(),
            createCustomerJson.getPhone(),
            createCustomerJson.getPostcode(),
            createCustomerJson.getNumber()
        );
    }
}
