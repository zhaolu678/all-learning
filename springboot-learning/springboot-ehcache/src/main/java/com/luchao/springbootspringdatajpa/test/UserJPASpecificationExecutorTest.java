package com.luchao.springbootspringdatajpa.test;

import com.luchao.springbootspringdatajpa.SpringbootSpringdatajpaApplication;
import com.luchao.springbootspringdatajpa.dao.jpasppecificationexecutor.UserJPASpecificationExecutor;
import com.luchao.springbootspringdatajpa.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootSpringdatajpaApplication.class})
public class UserJPASpecificationExecutorTest {
    @Autowired
    private UserJPASpecificationExecutor userJPASppecificationExecutor;

    /**
     * 单条件
     */
    @Test
    public void finduserbyusername(){
        Specification<User> specification = new Specification(){
            //Predicate：封装了单个查询条件
            /**
             *
             * @param root     查询对象的属性封装
             * @param criteriaQuery       封装了要执行的查询的各条件信息
             * @param criteriaBuilder     查询条件的构造器，定义不同的查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                // where name = '张'
                /**
                 * 参数一：查询的条件属性
                 * 参数二：条件的值
                 */
                Predicate predicate = criteriaBuilder.equal(root.get("username"),"张三");
                return predicate;
            }
        };
        List<User> users = userJPASppecificationExecutor.findAll(specification);
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username;"+users.get(i).toString());
        }
    }

    /**
     * 多条件
     */
    @Test
    public void finduserbyusernameandage(){
        Specification<User> specification = new Specification(){
            //Predicate：封装了单个查询条件
            /**
             *
             * @param root     查询对象的属性封装
             * @param criteriaQuery       封装了要执行的查询的各条件信息
             * @param criteriaBuilder     查询条件的构造器，定义不同的查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                // where name = '张' and age= 65
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("username"),"张三"));
                list.add(criteriaBuilder.equal(root.get("age"),"65"));
                Predicate[] arr = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(arr));
            }
        };
        List<User> users = userJPASppecificationExecutor.findAll(specification);
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username;"+users.get(i).toString());
        }
    }

    /**
     * 多条件二
     */
    @Test
    public void finduserbyusernameandage2(){
        Specification<User> specification = new Specification(){
            //Predicate：封装了单个查询条件
            /**
             *
             * @param root     查询对象的属性封装
             * @param criteriaQuery       封装了要执行的查询的各条件信息
             * @param criteriaBuilder     查询条件的构造器，定义不同的查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //username = '张三' and age=65 or id = 4
                return criteriaBuilder.or(criteriaBuilder.and(criteriaBuilder.equal(root.get("username"),"张三"),criteriaBuilder.equal(root.get("age"),"65")),criteriaBuilder.equal(root.get("id"),"4"));
            }
        };
        List<User> users = userJPASppecificationExecutor.findAll(specification);
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username;"+users.get(i).toString());
        }
    }
}
