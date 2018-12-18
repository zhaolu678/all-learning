package com.luchao.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.luchao.springbootrabbitmq.util.Constant.*;

@Configuration
public class TopicExchangeConfig {
    //设置队列
    @Bean
    public Queue topicmessage(){
        return new Queue(LU_CHAO_TOPIC_MESSAGE_MQ);
    }
    //设置队列
    @Bean
    public Queue topicmessages(){
        return new Queue(LU_CHAO_TOPIC_MESSAGES_MQ);
    }

    @Bean
    //创建主题交换机
    public TopicExchange topicExchange(){
        return new TopicExchange(LU_CHAO_TOPIC_EXCHANGE_EX);
    }

    @Bean
    //主题绑定队列,配置只接收一个队列
    public Binding bindingmessage(Queue topicmessage,TopicExchange topicExchange){
        return BindingBuilder.bind(topicmessage).to(topicExchange).with(LU_CHAO_TOPIC_MESSAGE_MQ);
    }
    @Bean
    /**
     * 这里的Topic Exchange 转发消息主要是根据通配符，队列topic.message只能匹配topic.message的路由。
     * 而topic.messages匹配路由规则是topic.#，所以它可以匹配topic.开头的全部路由。
     * 而topic.#发送的消息也只能是topic.#的接受者才能接收。
     */
    public Binding bindingmessages(Queue topicmessages,TopicExchange topicExchange){
        return BindingBuilder.bind(topicmessages).to(topicExchange).with("LuChao.Topic.#");
    }

}
