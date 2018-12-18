package com.luchao.springboothelloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/info")
    public String gethelloworld(){
        return "springboot HelloWrold!";
    }
}
