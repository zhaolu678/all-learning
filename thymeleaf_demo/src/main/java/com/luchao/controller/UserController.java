package com.luchao.controller;

import com.luchao.entity.User;
import com.luchao.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @RequestMapping("/list")
    public String getUserList(Model model) {
        List<User> list = userServices.getUserList();
        model.addAttribute("users", list);
        return "user/list";
    }

    @RequestMapping("toupdate")
    public String toupdateUser(Model model, Integer id) {
        System.out.println("====" + id);
        model.addAttribute("user", userServices.findUserById(id));
        return "user/userinfo";
    }

    @RequestMapping("update")
    public String updateUser(Model model, User user) {
        System.out.println("====" + user.toString());
        userServices.save(user);
        return "redirect:list";
    }

    @RequestMapping("toadd")
    public String toadd() {
        return "user/useradd";
    }

    @RequestMapping("add")
    public String addUser(User user) {
        userServices.save(user);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String deleteUser(Integer id) {
        userServices.delete(id);
        return "redirect:list";
    }

    @RequestMapping("other")
    public String tother(Model model) {
        List<User> list = userServices.getUserList();
        model.addAttribute("users", list);
        return "user/other";
    }
}
