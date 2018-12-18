package com.luchao.springbootmybatis.service;

import com.luchao.springbootmybatis.pojo.User;

import java.util.List;

public interface UserService {
    void adduser(User user);
    List<User> getAllUser();
    void deleteUser(int id);
    void updateUser(User user);
    User findUserById(int id);

}
