package com.fiap.g5.mscustomer.customer.controller.json;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateCustomerJson {
    private String name;
    private String email;
    private String phone;
    private String postcode;
    private Long number;
}
