package com.luchao.springbootmybatis.service.impl;

import com.luchao.springbootmybatis.pojo.User;
import com.luchao.springbootmybatis.mapper.UsersMapper;
import com.luchao.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void adduser(User user) {
        usersMapper.insterUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return usersMapper.getAllUser();
    }

    @Override
    public void deleteUser(int id) {
        usersMapper.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        usersMapper.updateUser(user);
    }

    @Override
    public User findUserById(int id) {
        return usersMapper.findUserById(id);
    }
}
