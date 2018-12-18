package com.luchao.springbootspringdatajpa.service;

import com.luchao.springbootspringdatajpa.pojo.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    Optional<User> findUserById(Integer id);
    void saveuser(User user);
    List<User> findalluser();
}
