package com.fiap.g5.mscustomer.customer.config.exception;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ExceptionHandlerConfigurationTest {

    private MockMvc mockMvc;

    @Test
    void testHandleSystemBaseException() throws Exception {
        ExceptionHandlerConfiguration exceptionHandler = new ExceptionHandlerConfiguration();
        mockMvc = MockMvcBuilders.standaloneSetup(exceptionHandler).build();

        mockMvc.perform(get("/exception/acessoRepositorioDados"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void testHandleGenericError() throws Exception {
        ExceptionHandlerConfiguration exceptionHandler = new ExceptionHandlerConfiguration();
        mockMvc = MockMvcBuilders.standaloneSetup(exceptionHandler).build();

        mockMvc.perform(get("//exception/customerNaoEncontrado"))
                .andExpect(status().isInternalServerError());
    }
}
