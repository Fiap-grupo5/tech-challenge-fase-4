package com.fiap.g5.mscustomer.customer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.g5.mscustomer.customer.controller.json.CustomerJson;
import com.fiap.g5.mscustomer.customer.domain.Customer;
import com.fiap.g5.mscustomer.customer.usecase.FindCustomerUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Slf4j
@CrossOrigin(origins = "*") //NOSONAR
@RequestMapping("/customer")
@RestController
@AllArgsConstructor
public class CustomerController {
    private FindCustomerUseCase findCustomerUseCase;

    @GetMapping("/{id}")
    public CustomerJson findCustomerById(@PathVariable("id") Long id) {
        Customer customer = findCustomerUseCase.findById(id);
        return new CustomerJson(customer);
    }
    
}
