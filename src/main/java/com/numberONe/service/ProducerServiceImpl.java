package com.numberONe.service;/**
 * Created by chenjia on 2018/5/24.
 */

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author chenjia
 * @create 2018-05-24 10:56
 * @desc
 **/
@Service(value = "producerService")
public class ProducerServiceImpl implements ProducerService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 向自定义的队列发消息
     * @param destination
     * @param msg
     */
    public void sendMessage(Destination destination, final String msg){
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发消息 "+msg);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    /**
     * 向默认的消息队列发消息
     * @param msg
     */
    public void sendMessage(final String msg){
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

}
