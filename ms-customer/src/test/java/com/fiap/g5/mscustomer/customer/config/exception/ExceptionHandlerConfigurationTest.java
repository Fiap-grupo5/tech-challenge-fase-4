package com.fiap.g5.mscustomer.customer.config.exception;

import com.fiap.g5.mscustomer.customer.exception.AcessoRepositorioDadosException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ExceptionHandlerConfigurationTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new ExceptionThrowingController())
                .setControllerAdvice(new ExceptionHandlerConfiguration())
                .build();
    }

    @Test
    void testHandleSystemBaseException() throws Exception {
        mockMvc.perform(get("/exception/acessoRepositorioDados"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.code").value("customer-service.erroAcessarRepositorioDados"))
                .andExpect(jsonPath("$.message").value("Erro ao acessar o repositorio de dados"));
    }

    @Test
    void testHandleGenericError() throws Exception {
        mockMvc.perform(get("/exception/generic"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.name()))
                .andExpect(jsonPath("$.message").value(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
    }

    @RestController
    @RequestMapping("/exception")
    static class ExceptionThrowingController {
        @GetMapping("/acessoRepositorioDados")
        public void throwSystemBaseException() {
            throw new AcessoRepositorioDadosException();
        }

        @GetMapping("/generic")
        public void throwGenericException() {
            throw new RuntimeException("Erro genérico");
        }
    }
}
