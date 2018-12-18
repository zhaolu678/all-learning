package com.luchao.springbootweb.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecondApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecondApplication.class,args);
    }
    @Bean
    public FilterRegistrationBean getfilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new SecondFilter());
        filterRegistrationBean.addUrlPatterns("/secondfilter");
        return filterRegistrationBean;
    }

}
