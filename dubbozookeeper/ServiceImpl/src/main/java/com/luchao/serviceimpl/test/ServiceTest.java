package com.luchao.serviceimpl.test;

import com.luchao.service.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        MyService myService = (MyService) context.getBean("myServiceImpl");
        System.out.println(myService);
    }
}
