package com.fiap.g5.mscustomer;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class MsCustomerApplication {

    public static void main(String[] args) {
        Locale.setDefault(new Locale( "pt", "BR" ));
        SpringApplication.run(MsCustomerApplication.class, args);
    }

}
