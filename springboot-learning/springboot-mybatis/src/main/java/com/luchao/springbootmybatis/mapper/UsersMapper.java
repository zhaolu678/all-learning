package com.luchao.springbootmybatis.mapper;

import com.luchao.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {

    void insterUser(User user);
    List<User> getAllUser();
    void deleteUser(int id);
    void updateUser(User user);
    User findUserById(int id);
    

}
