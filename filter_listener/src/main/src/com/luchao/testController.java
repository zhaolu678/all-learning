package com.luchao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class testController {

    @RequestMapping("index")
    public String getinfo(){
        System.out.println("进入到controller了！");
        return "success";
    }
}
