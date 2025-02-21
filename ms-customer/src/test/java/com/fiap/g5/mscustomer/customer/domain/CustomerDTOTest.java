package com.fiap.g5.mscustomer.customer.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDTOTest {

    @Test
    void testCustomerDTOGettersAndSetters() {
        CustomerDTO customerDTO = new CustomerDTO("Papa Francisco", "chico@example.com", "11999999999", "12345-678", 100L);

        assertEquals("Papa Francisco", customerDTO.getName());
        assertEquals("chico@example.com", customerDTO.getEmail());
        assertEquals("11999999999", customerDTO.getPhone());
        assertEquals("12345-678", customerDTO.getPostcode());
        assertEquals(100L, customerDTO.getNumber());

        customerDTO.setName("Jessie J");
        customerDTO.setEmail("jessie@example.com");
        customerDTO.setPhone("11988887777");
        customerDTO.setPostcode("54321-000");
        customerDTO.setNumber(200L);

        assertEquals("Jessie J", customerDTO.getName());
        assertEquals("jessie@example.com", customerDTO.getEmail());
        assertEquals("11988887777", customerDTO.getPhone());
        assertEquals("54321-000", customerDTO.getPostcode());
        assertEquals(200L, customerDTO.getNumber());
    }

    @Test
    void testCustomerDTOConstructorWithArgs() {
        CustomerDTO customerDTO = new CustomerDTO("Everton Ribeiro", "er7@example.com", "11977776666", "11111-222", 300L);

        assertEquals("Everton Ribeiro", customerDTO.getName());
        assertEquals("er7@example.com", customerDTO.getEmail());
        assertEquals("11977776666", customerDTO.getPhone());
        assertEquals("11111-222", customerDTO.getPostcode());
        assertEquals(300L, customerDTO.getNumber());
    }

    @Test
    void testCustomerDTOToString() {
        CustomerDTO customerDTO = new CustomerDTO("Ana Lima", "aninha@example.com", "11966665555", "55555-555", 400L);
        String expectedString = "CustomerDTO(name=Ana Lima, email=aninha@example.com, phone=11966665555, postcode=55555-555, number=400)";

        assertEquals(expectedString, customerDTO.toString());
    }
}
