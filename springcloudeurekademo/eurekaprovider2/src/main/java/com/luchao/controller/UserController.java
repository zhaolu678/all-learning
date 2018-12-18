package com.luchao.controller;
import com.luchao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    @Value("${server.port}")
    private int serviceport;

    @RequestMapping("/getuser")
    public List  getinfo(){
        List list = new ArrayList<>();
        list.add(new User(1,"zhangsan",20));
        list.add(new User(2,"lisi",22));
        list.add(new User(3,"wangwu",20));
        list.add(new User(4,"provider2端口号",serviceport));
        return list;
    }
}
