package com.luchao.springbootspringdatajpa.test;

import com.luchao.springbootspringdatajpa.SpringbootSpringdatajpaApplication;
import com.luchao.springbootspringdatajpa.dao.repository.UserRepositoryQueryAnnotaion;
import com.luchao.springbootspringdatajpa.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootSpringdatajpaApplication.class})
public class UserRepositoryQueryAnnotaionTest {
    @Autowired
    private UserRepositoryQueryAnnotaion userRepositoryQueryAnnotaion;

    @Test
    public void queryByUserNameHQL() {
        List<User> users = userRepositoryQueryAnnotaion.queryByUserNameHQL("张三");
        for (int i = 0; i < ((List) users).size(); i++) {
            System.out.println("userinfo:" + users.get(i).toString());
        }
    }

    @Test
    public void queryByUserNameSQL() {
        List<User> users = userRepositoryQueryAnnotaion.queryByUserNameSQL("张三");
        for (int i = 0; i < ((List) users).size(); i++) {
            System.out.println("userinfo:" + users.get(i).toString());
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    public void updateUserById() {
        userRepositoryQueryAnnotaion.updateUserById("王五",2);
    }
}
