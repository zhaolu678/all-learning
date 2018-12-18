package com.luchao.springbootspringdatajpa.dao.repository;

import com.luchao.springbootspringdatajpa.pojo.User;
import org.springframework.data.repository.Repository;
import java.util.List;

/**
 * 提供了方法名称命名查询方式
 * 提供了基于@Query注解查询与更新
 */
public interface UserRepository extends Repository<User,Integer> {

    List<User> findByUsername(String uname);
    List<User> findByUsernameAndAge(String uname,Integer age);
    List<User> findByUsernameLike(String uname);

}
