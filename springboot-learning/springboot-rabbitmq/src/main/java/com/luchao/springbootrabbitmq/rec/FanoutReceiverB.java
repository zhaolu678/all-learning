package com.luchao.springbootrabbitmq.rec;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.luchao.springbootrabbitmq.util.Constant.*;

@Component
@RabbitListener(queues = LU_CHAO_P_S_B_MQ)
public class FanoutReceiverB {

    @RabbitHandler
    public void getinfo(String msessage){
        System.out.println("FanoutReceiverB getinfo:"+msessage);
    }
}
