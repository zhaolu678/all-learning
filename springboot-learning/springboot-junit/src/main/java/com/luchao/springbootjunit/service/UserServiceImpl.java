package com.luchao.springbootjunit.service;

import com.luchao.springbootjunit.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDaoImpl userDao;

    public void  adduser(){
        userDao.adduser();
    }

}
