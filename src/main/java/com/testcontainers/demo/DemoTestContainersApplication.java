package com.testcontainers.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.testcontainers.demo"})
public class DemoTestContainersApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTestContainersApplication.class, args);
    }

}