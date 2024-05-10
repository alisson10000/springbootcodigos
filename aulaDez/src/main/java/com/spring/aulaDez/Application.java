package com.spring.aulaDez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.spring.aulaDez.repository"})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.*"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
