package com.fiap.g5.mscustomer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String postcode;
    private Integer number;
}
