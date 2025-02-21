package com.fiap.g5.mscustomer.customer.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SystemBaseExceptionTest {

    @Test
    void testAcessoRepositorioDadosException() {
        // Criar uma instância da exceção diretamente
        AcessoRepositorioDadosException exception = new AcessoRepositorioDadosException();

        // Verificar os valores atribuídos à exceção
        assertEquals("customer-service.erroAcessarRepositorioDados", exception.getCode());
        assertEquals("Erro ao acessar o repositorio de dados", exception.getMessage());
        assertEquals(500, exception.getHttpStatus());
    }

    @Test
    void testCustomerNaoEncontradoException() {
        // Criar uma instância da exceção diretamente
        CustomerNaoEncontradoException exception = new CustomerNaoEncontradoException();

        // Verificar os valores atribuídos à exceção
        assertEquals("customer-service.customerNaoEncontrado", exception.getCode());
        assertEquals("Customer não foi encontrado", exception.getMessage());
        assertEquals(404, exception.getHttpStatus());
    }
}
