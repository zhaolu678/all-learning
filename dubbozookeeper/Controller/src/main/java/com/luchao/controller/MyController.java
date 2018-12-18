package com.luchao.controller;

import com.luchao.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    @RequestMapping("/getdata/{str}")
    public String getData(@PathVariable String str) {
        System.out.println("=========================");
        String s = myService.getData(str);
        System.out.println("str:"+s);
        System.out.println("============ controller getData()=====================");
        return "succ";
    }

    @RequestMapping("/testPrint")
    public String testPrint(){
        myService.testPrint();
        return "succ";
    }


}
