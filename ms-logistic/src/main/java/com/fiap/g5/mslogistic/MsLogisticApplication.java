package com.fiap.g5.mslogistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsLogisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsLogisticApplication.class, args);
    }

}
