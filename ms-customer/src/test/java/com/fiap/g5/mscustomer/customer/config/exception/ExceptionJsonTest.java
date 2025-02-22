package com.fiap.g5.mscustomer.customer.config.exception;

import com.fiap.g5.mscustomer.customer.exception.AcessoRepositorioDadosException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionJsonTest {

    @Test
    void testExceptionJsonWithSystemBaseException() {
        AcessoRepositorioDadosException exception = new AcessoRepositorioDadosException();

        ExceptionJson exceptionJson = new ExceptionJson(exception);
        assertEquals("customer-service.erroAcessarRepositorioDados", exceptionJson.getCode());
        assertEquals("Erro ao acessar o repositorio de dados", exceptionJson.getMessage());
    }

    @Test
    void testExceptionJsonConstructorWithCodeAndMessage() {
        ExceptionJson exceptionJson = new ExceptionJson("custom-code", "Custom message");
        assertEquals("custom-code", exceptionJson.getCode());
        assertEquals("Custom message", exceptionJson.getMessage());
    }
}
