package com.spring.results.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spring.results")
public class StudentResultsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentResultsServiceApplication.class, args);
    }

}
