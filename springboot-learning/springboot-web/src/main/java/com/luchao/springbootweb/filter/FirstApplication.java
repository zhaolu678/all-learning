package com.luchao.springbootweb.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FirstApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class,args);
    }
}
