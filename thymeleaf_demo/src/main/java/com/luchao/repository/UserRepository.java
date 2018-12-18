package com.luchao.repository;

import com.luchao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(Integer id);
    Long deleteById(Integer id);
}
