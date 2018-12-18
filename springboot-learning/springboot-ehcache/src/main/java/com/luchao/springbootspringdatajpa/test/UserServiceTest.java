package com.luchao.springbootspringdatajpa.test;

import com.luchao.springbootspringdatajpa.SpringbootSpringdatajpaApplication;
import com.luchao.springbootspringdatajpa.pojo.User;
import com.luchao.springbootspringdatajpa.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootSpringdatajpaApplication.class})
public class UserServiceTest {
    @Autowired
    private UsersService usersService;
    @Test
    public void testfinduserbyid(){
        //第一给查询
        System.out.println(usersService.findUserById(2).toString());
        //第二给查询
        System.out.println(usersService.findUserById(2).toString());
    }

    @Test
    public void testfindsave(){
        //第一给查询
        System.out.println(usersService.findalluser());

        User user = new User();
        user.setUsername("烧饼");
        user.setAge(12);
        usersService.saveuser(user);

        //第二给查询
        System.out.println(usersService.findalluser());
    }

}
