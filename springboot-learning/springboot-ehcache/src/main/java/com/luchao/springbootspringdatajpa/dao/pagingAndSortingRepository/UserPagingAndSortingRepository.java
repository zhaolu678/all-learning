package com.luchao.springbootspringdatajpa.dao.pagingAndSortingRepository;

import com.luchao.springbootspringdatajpa.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User,Integer> {
}
