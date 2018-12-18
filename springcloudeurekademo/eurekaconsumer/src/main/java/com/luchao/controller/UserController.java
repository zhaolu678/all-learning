package com.luchao.controller;

import com.luchao.pojo.User;
import com.luchao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public List<User> getinfo(){
        return userService.getUsers("/getuser");
    }
}
