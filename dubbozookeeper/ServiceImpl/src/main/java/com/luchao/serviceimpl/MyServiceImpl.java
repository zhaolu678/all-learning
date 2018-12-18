package com.luchao.serviceimpl;

import com.luchao.service.MyService;
import org.springframework.stereotype.Service;

@Service("myServiceImpl")
public class MyServiceImpl implements MyService {
    public String getData(String name) {
        return "hello "+name;
    }

    public void testPrint() {
        System.out.println("======toPrint()======");
    }
}
