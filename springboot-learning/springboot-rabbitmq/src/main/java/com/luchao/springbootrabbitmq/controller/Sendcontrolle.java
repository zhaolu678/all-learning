package com.luchao.springbootrabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.luchao.springbootrabbitmq.util.Constant.*;

@RestController
public class Sendcontrolle {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送单挑信息到队列
     * @return
     */
    @RequestMapping(value = "/send")
    public String sendinfo(){
        String strdate = "Date:"+new Date();
        amqpTemplate.convertAndSend(LU_CHAO_DATE_MQ,strdate);
        return strdate;
    }

    /**
     * 一次发送多条到队列
     * @return
     */
    @RequestMapping(value = "/sendmore")
    public String sendmoreinfo(){
        for (int i = 0; i < 10; i++) {
            String strdate = "Date:"+new Date();
            amqpTemplate.convertAndSend(LU_CHAO_DATE_MQ,strdate);
        }
        return "OK";
    }
    //往一个主题中的一个队列发送消息
    @RequestMapping("/topicsend1")
    public String topicsend1(){
        amqpTemplate.convertAndSend(LU_CHAO_TOPIC_EXCHANGE_EX, LU_CHAO_TOPIC_MESSAGE_MQ,"i am topic1");
        return "OK";
    }
    //往一个主题中的一个队列发送消息
    @RequestMapping("/topicsend2")
    public String topicsend2(){
        amqpTemplate.convertAndSend(LU_CHAO_TOPIC_EXCHANGE_EX, LU_CHAO_TOPIC_MESSAGES_MQ,"i am topic2");
        return "OK";
    }

    //发布订阅模式发送信息
    @RequestMapping("/pssend")
    public String pssend(){
        amqpTemplate.convertAndSend(LU_CHAO_FANOUT_EXCHANGE_EX,"","我是发布订阅者！");
        return "OK";
    }

    //路由发布消息
    @RequestMapping("/routingsend/{routingKey}/{message}")
    public String routingsend(@PathVariable String routingKey,@PathVariable String message){
        amqpTemplate.convertAndSend(LU_CHAO_DIRECT_EXCHANGE_EX,routingKey,message);
        return "OK!";
    }
}
