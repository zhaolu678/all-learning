package com.luchao.springbootmybatis.controller;

import com.luchao.springbootmybatis.pojo.User;
import com.luchao.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 增加用户
     * @return
     */
    @RequestMapping("/adduser")
    public String adduser(Model model, @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            System.out.println("=====has error=");
            return "add";
        } else {
            if (null != user.getId()) {
                userService.updateUser(user);
            } else {
                System.out.println("====正确");
                userService.adduser(user);
            }
            return "redirect:/";
        }
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/")
    public String findAllUser(Model model) {
        List list = userService.getAllUser();
        model.addAttribute("ulist", list);
        return "list";
    }


    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    /**
     * 跳转到修改用户界面，查询出该用户
     * @return
     */
    @RequestMapping("/toupdate/{id}")
    public String toupdate(Model model, @PathVariable Integer id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "add";
    }

    @RequestMapping(value = "/toadd")
    public String toadd(User user) {
        return "add";
    }
}
