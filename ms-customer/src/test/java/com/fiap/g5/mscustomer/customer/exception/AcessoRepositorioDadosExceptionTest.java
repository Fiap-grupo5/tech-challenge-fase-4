package com.fiap.g5.mscustomer.customer.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcessoRepositorioDadosExceptionTest {

    @Test
    void testAcessoRepositorioDadosException() {
        // Act: Criar uma instância da exceção
        AcessoRepositorioDadosException exception = new AcessoRepositorioDadosException();

        // Assert: Verificar os valores atribuídos à exceção
        assertEquals("customer-service.erroAcessarRepositorioDados", exception.getCode());
        assertEquals("Erro ao acessar o repositorio de dados", exception.getMessage());
        assertEquals(500, exception.getHttpStatus());
    }
}
