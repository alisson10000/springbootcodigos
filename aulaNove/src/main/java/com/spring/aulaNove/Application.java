package com.spring.aulaNove;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.spring.aulaNove")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
