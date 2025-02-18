package com.fiap.g5.mscustomer.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CreateCustomer {
    private String name;
    private String email;
    private String phone;
    private String postcode;
    private Long number;
}
