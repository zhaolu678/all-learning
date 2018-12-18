package com.luchao.springbootrabbitmq.rec;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.luchao.springbootrabbitmq.util.Constant.LU_CHAO_DATE_MQ;

@Component
@RabbitListener(queues = LU_CHAO_DATE_MQ)
public class Receiver2 {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("接收者2："+msg);
    }
}
