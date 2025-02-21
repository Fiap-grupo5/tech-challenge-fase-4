package com.fiap.g5.mslogistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// Caso queira usar Batch, habilite: @EnableBatchProcessing

@SpringBootApplication
@EnableDiscoveryClient
public class MsLogisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsLogisticApplication.class, args);
    }
}
