package com.luchao.filter;

import org.apache.activemq.Message;
import org.apache.activemq.broker.region.MessageReference;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.memory.list.MessageList;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.List;

public class QueueMessageListener implements MessageList {
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息：\t"
                    + tm.getText());
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(MessageReference messageReference) {

    }

    @Override
    public List getMessages(ActiveMQDestination activeMQDestination) {
        return null;
    }

    @Override
    public org.apache.activemq.command.Message[] browse(ActiveMQDestination activeMQDestination) {
        return new org.apache.activemq.command.Message[0];
    }

    @Override
    public void clear() {

    }
}
