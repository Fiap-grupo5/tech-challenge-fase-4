package com.fiap.g5.mscustomer.customer.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String postcode;
    private Long number;
}
