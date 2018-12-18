package com.luchao.springbootjunit;
import com.luchao.springbootjunit.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootJunitApplication.class})
public class JunitDemo {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void addusertest(){
        userService.adduser();
    }
}
