package com.luchao.services;

import com.luchao.entity.User;

import java.util.List;

public interface UserServices {
    public List<User> getUserList();

    public User findUserById(Integer id);

    public void save(User user);

    public void edit(User user);

    public void delete(Integer id);


}
