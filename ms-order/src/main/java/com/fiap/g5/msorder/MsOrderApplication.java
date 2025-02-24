package com.fiap.g5.msorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MsOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class, args);
    }
}
