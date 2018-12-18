package com.luchao.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.luchao.springbootrabbitmq.util.Constant.*;

@Configuration
public class RoutingConfig {

    //队列声明
    @Bean
    public Queue routingA(){
        return new Queue(LU_CHAO_ROUTING_A_MQ);
    }
    @Bean
    public Queue routingB(){
        return new Queue(LU_CHAO_ROUTING_B_MQ);
    }
    //路由声明
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(LU_CHAO_DIRECT_EXCHANGE_EX);
    }

    //绑定
    @Bean
    public Binding bindingroutingA(Queue routingA,DirectExchange directExchange){
        return BindingBuilder.bind(routingA).to(directExchange).with("aaa");
    }
    @Bean
    public Binding bindingroutingB(Queue routingB,DirectExchange directExchange){
        return BindingBuilder.bind(routingB).to(directExchange).with("bbb");
    }
}
