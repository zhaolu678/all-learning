package com.luchao.springbootspringdatajpa.test;

import com.luchao.springbootspringdatajpa.SpringbootSpringdatajpaApplication;
import com.luchao.springbootspringdatajpa.dao.repository.UserRepository;
import com.luchao.springbootspringdatajpa.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootSpringdatajpaApplication.class})
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserByUserName() {
        List<User> users = userRepository.findByUsername("路灯");
        for (int i = 0; i < ((List) users).size(); i++) {
            System.out.println("userinfo:"+users.get(i).toString());
        }
    }
    @Test
    public void findByUsernameAndAge() {
        List<User> users = userRepository.findByUsernameAndAge("路灯",23);
        for (int i = 0; i < ((List) users).size(); i++) {
            System.out.println("userinfo:"+users.get(i).toString());
        }
    }

    @Test
    public void findByUsernameLike() {
        List<User> users = userRepository.findByUsernameLike("路%");
        for (int i = 0; i < ((List) users).size(); i++) {
            System.out.println("userinfo:"+users.get(i).toString());
        }
    }
}
