package com.spring.novoseguranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Spring Boot application starter class
 */

@SpringBootApplication(scanBasePackages = "com.spring.novoseguranca")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
