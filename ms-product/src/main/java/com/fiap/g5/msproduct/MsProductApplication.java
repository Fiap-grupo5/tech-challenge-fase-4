package com.fiap.g5.msproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import java.util.Locale;

@EnableDiscoveryClient
@EnableBatchProcessing
@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class MsProductApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pt", "BR"));
        SpringApplication.run(MsProductApplication.class, args);
    }
}
