package com.fiap.g5.mscustomer.customer.controller.json;

import com.fiap.g5.mscustomer.customer.domain.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerJsonTest {

    @Test
    void shouldCreateCustomerJsonFromCustomer() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Ronaldinho Gaúcho");
        customer.setEmail("ronaldinho@example.com");
        customer.setPhone("11999999999");
        customer.setPostcode("12345-678");
        customer.setNumber(100L);

        CustomerJson customerJson = new CustomerJson(customer);

        assertNotNull(customerJson);
        assertEquals(1L, customerJson.getId());
        assertEquals("Ronaldinho Gaúcho", customerJson.getName());
        assertEquals("ronaldinho@example.com", customerJson.getEmail());
        assertEquals("11999999999", customerJson.getPhone());
        assertEquals("12345-678", customerJson.getPostcode());
        assertEquals(100L, customerJson.getNumber());
    }
}
