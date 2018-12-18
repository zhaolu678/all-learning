package com.luchao.springbootspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootSpringdatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringdatajpaApplication.class, args);
    }
}
