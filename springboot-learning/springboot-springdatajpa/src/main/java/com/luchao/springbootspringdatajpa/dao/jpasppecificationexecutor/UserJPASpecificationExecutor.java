package com.luchao.springbootspringdatajpa.dao.jpasppecificationexecutor;

import com.luchao.springbootspringdatajpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserJPASpecificationExecutor extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {
}
