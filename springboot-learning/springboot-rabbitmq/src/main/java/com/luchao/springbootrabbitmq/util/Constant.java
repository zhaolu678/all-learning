package com.luchao.springbootrabbitmq.util;

/**
 * 常量类
 */
public class Constant {
    //队列名称
    public static final String LU_CHAO_DATE_MQ = "LuChao.Date.MQ";

    //主题名
    //交换机
    public static final String LU_CHAO_TOPIC_EXCHANGE_EX = "LuChao.TopicExchange.EX";
   //对列名
    public static final String LU_CHAO_TOPIC_MESSAGE_MQ = "LuChao.Topic.Message.MQ";
    public static final String LU_CHAO_TOPIC_MESSAGES_MQ = "LuChao.Topic.Messages.MQ";

    //发布订阅
    //分发交换机
    public static final String LU_CHAO_FANOUT_EXCHANGE_EX ="LuChao.FanoutExchange.EX";
    //队列名
    public static final String LU_CHAO_P_S_A_MQ="LuChao.Publish.Subscribe.A.MQ";
    public static final String LU_CHAO_P_S_B_MQ="LuChao.Publish.Subscribe.B.MQ";
    public static final String LU_CHAO_P_S_C_MQ="LuChao.Publish.Subscribe.C.MQ";

    //路由模式
    //路由器
    public static final String LU_CHAO_DIRECT_EXCHANGE_EX="LuChao.DirectExchange.EX";
    //队列名
    public static final String LU_CHAO_ROUTING_A_MQ="LuChao.Routing.A.MQ";
    public static final String LU_CHAO_ROUTING_B_MQ="LuChao.Routing.B.MQ";
}
