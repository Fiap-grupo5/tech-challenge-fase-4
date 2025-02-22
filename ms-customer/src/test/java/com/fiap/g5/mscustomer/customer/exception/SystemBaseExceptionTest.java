package com.fiap.g5.mscustomer.customer.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SystemBaseExceptionTest {

    @Test
    void testAcessoRepositorioDadosException() {
        AcessoRepositorioDadosException exception = new AcessoRepositorioDadosException();

        assertEquals("customer-service.erroAcessarRepositorioDados", exception.getCode());
        assertEquals("Erro ao acessar o repositorio de dados", exception.getMessage());
        assertEquals(500, exception.getHttpStatus());
    }

    @Test
    void testCustomerNaoEncontradoException() {
        CustomerNaoEncontradoException exception = new CustomerNaoEncontradoException();

        assertEquals("customer-service.customerNaoEncontrado", exception.getCode());
        assertEquals("Customer não foi encontrado", exception.getMessage());
        assertEquals(404, exception.getHttpStatus());
    }
}
