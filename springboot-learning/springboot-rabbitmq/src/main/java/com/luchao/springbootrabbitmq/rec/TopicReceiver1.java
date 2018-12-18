package com.luchao.springbootrabbitmq.rec;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.luchao.springbootrabbitmq.util.Constant.LU_CHAO_TOPIC_MESSAGE_MQ;

@Component
@RabbitListener(queues = LU_CHAO_TOPIC_MESSAGE_MQ)
public class TopicReceiver1 {

    @RabbitHandler
    public void getinfo(String msg){
        System.out.println("TopicReceiver1:"+msg);
    }

}
