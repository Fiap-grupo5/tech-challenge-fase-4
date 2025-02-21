package com.fiap.g5.mscustomer.customer.controller.json;

import com.fiap.g5.mscustomer.customer.domain.Customer;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CustomerJson {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String postcode;
    private Long number;

    public CustomerJson(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.postcode = customer.getPostcode();
        this.number = customer.getNumber();
    }
}
