package com.luchao.springbootspringdatajpa.dao.repository;

import com.luchao.springbootspringdatajpa.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepositoryQueryAnnotaion extends Repository<User,Integer> {

    @Query("from User where username = :uname ")
    List<User> queryByUserNameHQL(@Param("uname") String uname);
    @Query(value = "select * from user where username = :uname",nativeQuery = true)
    List<User> queryByUserNameSQL(@Param("uname") String uname);
    @Query(value ="update user set username=:uname where id=:id",nativeQuery = true)
    @Modifying
    void updateUserById(@Param("uname")String uname,@Param("id")Integer id);
}
