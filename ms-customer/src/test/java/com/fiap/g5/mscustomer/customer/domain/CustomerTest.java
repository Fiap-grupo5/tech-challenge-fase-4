package com.fiap.g5.mscustomer.customer.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testCustomerGettersAndSetters() {
        Customer customer = new Customer();

        customer.setId(1L);
        customer.setName("Lady Gaga");
        customer.setEmail("gaga@example.com");
        customer.setPhone("11999999999");
        customer.setPostcode("12345-678");
        customer.setNumber(100L);

        assertEquals(1L, customer.getId());
        assertEquals("Lady Gaga", customer.getName());
        assertEquals("gaga@example.com", customer.getEmail());
        assertEquals("11999999999", customer.getPhone());
        assertEquals("12345-678", customer.getPostcode());
        assertEquals(100L, customer.getNumber());
    }

    @Test
    void testCustomerConstructorWithArgs() {
        Customer customer = new Customer(1L, "Papa Francisco", "chico@example.com", "11988887777", "54321-000", 200L);

        assertEquals(1L, customer.getId());
        assertEquals("Papa Francisco", customer.getName());
        assertEquals("chico@example.com", customer.getEmail());
        assertEquals("11988887777", customer.getPhone());
        assertEquals("54321-000", customer.getPostcode());
        assertEquals(200L, customer.getNumber());
    }

    @Test
    void testCustomerToString() {
        Customer customer = new Customer(1L, "Carlos Mendes", "carlos@example.com", "11977776666", "11111-222", 300L);
        String expectedString = "Customer(id=1, name=Carlos Mendes, email=carlos@example.com, phone=11977776666, postcode=11111-222, number=300)";

        assertEquals(expectedString, customer.toString());
    }
}
