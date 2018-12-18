package com.luchao.springbootspringdataredis.test;

import com.luchao.springbootspringdataredis.SpringbootSpringdataredisApplication;
import com.luchao.springbootspringdataredis.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootSpringdataredisApplication.class)
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存对象
     */
    @Test
    public void saveuser() {
        User user = new User();
        user.setAge(11);
        user.setName("luchao111");
        user.setId(1);
        redisTemplate.opsForValue().set(1 + "", user);
        User user1 = (User) redisTemplate.opsForValue().get(1 + "");
        System.out.println(user1.getName());
    }

    @Test
    public void savehash() {
        for (int i = 0; i < 10; i++) {
            User u = new User(i, "王" + i, 12);
            redisTemplate.opsForHash().put("mychach", u.getId(), u);
        }
        ArrayList list = (ArrayList) redisTemplate.opsForHash().get("mychach", User.class);
        for (int j = 0; j < list.size(); j++) {
            User uuu = (User) list.get(j);
            System.out.println(uuu);
        }

    }


}
