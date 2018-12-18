package com.luchao.springbootredis.test;

import com.luchao.springbootredis.SpringbootRedisApplication;
import com.luchao.springbootredis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootRedisApplication.class)
public class ReidsTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void setvalue() {
        redisTemplate.opsForValue().set("name", "luchao");
    }
    @Test
    public void getvalue(){
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    /**
     * 存对象
     */
    @Test
    public void setUser(){
        User users = new User();
        users.setAge(20);
        users.setName("张三丰");
        users.setId(1);

        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set("user",users);
    }

    /**
     * 取Users对象
     */
    @Test
    public void testGetUsers(){
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User users = (User)this.redisTemplate.opsForValue().get("user");
        System.out.println(users);
    }

    /**
     * 基于JSON格式存Users对象
     */
    @Test
    public void testSetUsersUseJSON(){
        User users = new User();
        users.setAge(20);
        users.setName("李四丰");
        users.setId(1);
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        this.redisTemplate.opsForValue().set("users_json", users);
    }

    /**
     * 基于JSON格式取Users对象
     */
    @Test
    public void testGetUseJSON(){
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User users = (User)this.redisTemplate.opsForValue().get("users_json");
        System.out.println(users);
    }

}
