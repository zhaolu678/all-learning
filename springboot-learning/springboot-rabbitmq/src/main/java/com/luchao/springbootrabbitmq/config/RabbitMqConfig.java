package com.luchao.springbootrabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static com.luchao.springbootrabbitmq.util.Constant.LU_CHAO_DATE_MQ;


/**
 * 普通队列（一对一）
 * 工作队列（一对多队列）
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    //创建普通队列
    public Queue qu1(){
        return new Queue(LU_CHAO_DATE_MQ);
    }


}
