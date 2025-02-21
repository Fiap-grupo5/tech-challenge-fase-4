package com.fiap.g5.mscustomer.customer.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerNaoEncontradoExceptionTest {

    @Test
    void testCustomerNaoEncontradoException() {
        // Act: Criar uma instância da exceção
        CustomerNaoEncontradoException exception = new CustomerNaoEncontradoException();

        // Assert: Verificar os valores atribuídos à exceção
        assertEquals("customer-service.customerNaoEncontrado", exception.getCode());
        assertEquals("Customer não foi encontrado", exception.getMessage());
        assertEquals(404, exception.getHttpStatus());
    }
}
