package com.luchao.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.luchao.springbootrabbitmq.util.Constant.*;

@Configuration
public class PublishSubscribeConfig {

    //声明队列
    @Bean
    public Queue AMessage(){
        return new Queue(LU_CHAO_P_S_A_MQ);
    }
    @Bean
    public Queue BMessage(){
        return new Queue(LU_CHAO_P_S_B_MQ);
    }
    @Bean
    public Queue CMessage(){
        return new Queue(LU_CHAO_P_S_C_MQ);
    }

    @Bean
    //声明分发交换机
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(LU_CHAO_FANOUT_EXCHANGE_EX);
    }
    @Bean
    //A队列和交换机绑定
    public Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    @Bean
    //B队列和交换机绑定
    public Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    @Bean
    //C队列和交换机绑定
    public Binding bindingExchangeC(Queue CMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
