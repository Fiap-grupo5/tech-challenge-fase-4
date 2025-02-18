package com.fiap.g5.msproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

@SpringBootApplication
@EnableDiscoveryClient 
@EnableBatchProcessing  
public class MsProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsProductApplication.class, args);
    }
}
