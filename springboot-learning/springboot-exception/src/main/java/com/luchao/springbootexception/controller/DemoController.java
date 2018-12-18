package com.luchao.springbootexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/test")
    public String toinfo() {
        System.out.println("====");
        String str = null;
        str.length();
        return "login";
    }

    @RequestMapping("test2")
    public String test2() {
        int a = 10;
        a = a / 0;
        return "login";
    }

}
