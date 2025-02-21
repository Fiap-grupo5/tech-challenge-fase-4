package com.fiap.g5.mslogistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class MsLogisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsLogisticApplication.class, args);
    }

}
