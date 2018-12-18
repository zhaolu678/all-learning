package com.luchao.springbootspringdatajpa.dao.crudrepository;

import com.luchao.springbootspringdatajpa.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCRUDRepository extends CrudRepository<User,Integer> {
}
