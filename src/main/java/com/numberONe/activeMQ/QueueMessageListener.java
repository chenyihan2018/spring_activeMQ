package com.numberONe.activeMQ;/**
 * Created by chenjia on 2018/5/24.
 */

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author chenjia
 * @create 2018-05-24 10:49
 * @desc 消息队列 监听
 **/
public class QueueMessageListener implements MessageListener{
    public void onMessage(Message message) {
         TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("监听的消息: "+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
