package com.luchao.springbootspringdataredis.test;

import com.luchao.springbootspringdataredis.SpringbootSpringdataredisApplication;
import com.luchao.springbootspringdataredis.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootSpringdataredisApplication.class)
public class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 存String值
     */
    @Test
    public void savestring() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
        //向redis里存入数据和设置缓存时间  10秒
        stringRedisTemplate.opsForValue().set("bbb", "222", 10, TimeUnit.SECONDS);
    }

    /**
     * 取String值
     */
    @Test
    public void getstring() {
        String string = stringRedisTemplate.opsForValue().get("aaa");
        System.out.println("==" + string);
    }

    //List存操作
    @Test
    public void listPushRedisList(){
        // leftPush依次由右边添加
        stringRedisTemplate.opsForList().rightPush("mylist","111");
        stringRedisTemplate.opsForList().rightPush("mylist","111");
        stringRedisTemplate.opsForList().rightPush("mylist","AAA");
        stringRedisTemplate.opsForList().rightPush("mylist","BBB");
        // leftPush依次由左边添加
        stringRedisTemplate.opsForList().leftPush("mylist", "0");
        stringRedisTemplate.opsForList().leftPush("mylist",new User(1,"王",12).toString());
    }

    //List取值
    @Test
    public void listGetListResitTest(){
        // 查询类别所有元素
        List<String> listAll = stringRedisTemplate.opsForList().range( "mylist", 0, -1);
        System.out.println("list all:" + listAll);
        // 查询前3个元素
        List<String> list = stringRedisTemplate.opsForList().range( "mylist", 0, 3);
        System.out.println("list limit："+list);
    }

    //删除
    @Test
    public void listRemoveOneResitTest(){
        // 删除先进入的BBB元素
        stringRedisTemplate.opsForList().remove("mylist",1, "BBB");
    }

    @Test
    public void listRemoveAllResitTest(){
        // 删除所有AAA元素,全匹配
        stringRedisTemplate.opsForList().remove("mylist",0, "AAA");
    }

}
