package com.luchao.springbootspringdatajpa.test;

import com.luchao.springbootspringdatajpa.SpringbootSpringdatajpaApplication;
import com.luchao.springbootspringdatajpa.dao.pagingAndSortingRepository.UserPagingAndSortingRepository;
import com.luchao.springbootspringdatajpa.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootSpringdatajpaApplication.class})
public class UserPagingAndSortingRepositoryTest {
    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    /**
     * 排序
     */
    @Test
    public void testUserPagingAndSortingRepositorySorting(){
        Sort sort = new Sort(Sort.Direction.DESC, "age");
        List<User> users = (List<User>) userPagingAndSortingRepository.findAll(sort);
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username;"+users.get(i).getUsername());
        }
    }

    /**
     * 分页
     */
    @Test
    public void testUserPagingAndSortingRepositoryPaging(){
        //Pageable：封装了分页参数，当前页，每页显示条数。注意：页数从0开始
        //PageRequest(int page, int size)  page：当前页，size：每页条数
        Pageable pageable = new PageRequest(0,2);
        Page<User> page =  userPagingAndSortingRepository.findAll(pageable);
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        List<User> users = page.getContent();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username;"+users.get(i).toString());
        }
    }

    /**
     * 分页+排序
     */
    @Test
    public void testUserPagingAndSortingRepositoryPagingAndSorting(){
        //Pageable：封装了分页参数，当前页，每页显示条数。注意：页数从0开始
        //PageRequest(int page, int size)  page：当前页，size：每页条数
        Sort sort = new Sort(Sort.Direction.ASC, "age");
        Pageable pageable = new PageRequest(0,2,sort);
        Page<User> page =  userPagingAndSortingRepository.findAll(pageable);
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        List<User> users = page.getContent();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username;"+users.get(i).toString());
        }
    }


}
