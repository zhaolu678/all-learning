package com.luchao.springbootrabbitmq.rec;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.luchao.springbootrabbitmq.util.Constant.LU_CHAO_ROUTING_A_MQ;

@Component
@RabbitListener(queues = LU_CHAO_ROUTING_A_MQ)
public class RoutingReceiverA {

    @RabbitHandler
    public void routingrec(String message){
        System.out.println("RoutingReceiverA:"+message);
    }
}
