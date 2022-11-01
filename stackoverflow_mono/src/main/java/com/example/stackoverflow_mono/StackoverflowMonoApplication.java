package com.example.stackoverflow_mono;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class StackoverflowMonoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowMonoApplication.class, args);
    }

}
