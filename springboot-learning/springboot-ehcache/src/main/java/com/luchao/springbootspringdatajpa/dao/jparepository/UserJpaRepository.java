package com.luchao.springbootspringdatajpa.dao.jparepository;

import com.luchao.springbootspringdatajpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository  extends JpaRepository<User,Integer> {
}
