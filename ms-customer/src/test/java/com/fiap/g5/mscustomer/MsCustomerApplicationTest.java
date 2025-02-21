package com.fiap.g5.mscustomer;

import static org.assertj.core.api.Assertions.assertThat;

import com.fiap.g5.mscustomer.customer.usecase.CreateCustomerUseCase;
import com.fiap.g5.mscustomer.customer.usecase.DeleteCustomerUseCase;
import com.fiap.g5.mscustomer.customer.usecase.FindAllCustomerUseCase;
import com.fiap.g5.mscustomer.customer.usecase.UpdateCustomerUseCase;
import com.fiap.g5.mscustomer.customer.config.exception.ExceptionHandlerConfiguration;
import com.fiap.g5.mscustomer.customer.gateway.CustomerGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class MsCustomerApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void testBeansAreLoaded() {
        assertThat(applicationContext.getBean(CreateCustomerUseCase.class)).isNotNull();
        assertThat(applicationContext.getBean(DeleteCustomerUseCase.class)).isNotNull();
        assertThat(applicationContext.getBean(FindAllCustomerUseCase.class)).isNotNull();
        assertThat(applicationContext.getBean(UpdateCustomerUseCase.class)).isNotNull();
        assertThat(applicationContext.getBean(ExceptionHandlerConfiguration.class)).isNotNull();
        assertThat(applicationContext.getBean(CustomerGateway.class)).isNotNull();
    }
}
