package com.luchao.springbootrabbitmq.rec;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.luchao.springbootrabbitmq.util.Constant.LU_CHAO_TOPIC_MESSAGES_MQ;

@Component
@RabbitListener(queues = LU_CHAO_TOPIC_MESSAGES_MQ)
public class TopicReceiver2 {

    @RabbitHandler
    public void getinfo(String msg){
        System.out.println("TopicReceiver2:"+msg);
    }

}
