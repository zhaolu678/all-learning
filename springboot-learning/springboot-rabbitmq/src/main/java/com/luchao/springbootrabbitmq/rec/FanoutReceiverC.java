package com.luchao.springbootrabbitmq.rec;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.luchao.springbootrabbitmq.util.Constant.*;

@Component
@RabbitListener(queues = LU_CHAO_P_S_C_MQ)
public class FanoutReceiverC {

    @RabbitHandler
    public void getinfo(String msessage){
        System.out.println("FanoutReceiverC getinfo:"+msessage);
    }
}
