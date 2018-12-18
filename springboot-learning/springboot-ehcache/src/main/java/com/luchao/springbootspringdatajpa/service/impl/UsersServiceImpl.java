package com.luchao.springbootspringdatajpa.service.impl;

import com.luchao.springbootspringdatajpa.dao.jparepository.UserJpaRepository;
import com.luchao.springbootspringdatajpa.pojo.User;
import com.luchao.springbootspringdatajpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Override
    //@Cacheable:对当前查询的对象做缓存处理
    @Cacheable(value="users")
    public Optional<User> findUserById(Integer id) {
        return userJpaRepository.findById(id);
    }

    @Override
    @CacheEvict(value="users",allEntries=true)
    public void saveuser(User user) {
        userJpaRepository.save(user);
    }

    @Override
    @Cacheable(value="users")
    public List<User> findalluser() {
        return userJpaRepository.findAll();
    }
}
