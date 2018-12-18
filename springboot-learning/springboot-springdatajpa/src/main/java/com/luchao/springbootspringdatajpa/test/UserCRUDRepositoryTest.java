package com.luchao.springbootspringdatajpa.test;

import com.luchao.springbootspringdatajpa.SpringbootSpringdatajpaApplication;
import com.luchao.springbootspringdatajpa.dao.crudrepository.UserCRUDRepository;
import com.luchao.springbootspringdatajpa.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootSpringdatajpaApplication.class})
public class UserCRUDRepositoryTest {

    @Autowired
    private UserCRUDRepository userCRUDRepository;

    @Test
    public void addUser() {
        User user = new User();
        user.setAge(13);
        user.setUsername("gaoyn");
        userCRUDRepository.save(user);
    }

    /**
     * 删除
     */
    @Test
    public void delUser(){
        User user = new User();
        user.setId(8);
        userCRUDRepository.deleteById(6);
        //userCRUDRepository.delete(user);
    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(12);
        user.setAge(23);
        user.setUsername("赵路");
        userCRUDRepository.save(user);
    }

    /**
     * 查询所有/排序
     */
    @Test
    public void findUser(){
//        List<User> users = userJpaRepository.findAll();
        List<User> users = (List<User>) userCRUDRepository.findAll();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username;"+users.get(i).getUsername());
        }
    }
}
