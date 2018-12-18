package com.luchao.springbootjunit.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl {

    public void adduser(){
        System.out.println("=======新增用户！========");
    }
}
