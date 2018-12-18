package com.luchao.springbootspringdatajpa.test;

import com.luchao.springbootspringdatajpa.SpringbootSpringdatajpaApplication;
import com.luchao.springbootspringdatajpa.dao.jparepository.UserJpaRepository;
import com.luchao.springbootspringdatajpa.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootSpringdatajpaApplication.class})
public class UserJpaRepositoryTest {
    @Autowired
    private UserJpaRepository userJpaRepository;

    /**
     * 新增
     */
    @Test
    public void addUser() {
        User user = new User();
        user.setAge(12);
        user.setUsername("luchao");
        userJpaRepository.save(user);
    }

    /**
     * 删除
     */
    @Test
    public void delUser(){
        User user = new User();
        user.setId(13);
        userJpaRepository.delete(user);
    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(12);
        user.setAge(12);
        user.setUsername("luchao");
        userJpaRepository.save(user);
    }

    /**
     * 查询所有/排序
     */
    @Test
    public void findUser(){
//        List<User> users = userJpaRepository.findAll();
//        Sort sort = new Sort(Sort.Direction.DESC, "username");
        Sort sort = new Sort(Sort.Direction.DESC, "age");
        List<User> users = userJpaRepository.findAll(sort);
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username;"+users.get(i).getUsername());
        }
    }
}
