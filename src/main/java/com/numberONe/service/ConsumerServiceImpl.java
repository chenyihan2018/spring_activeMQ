package com.numberONe.service;/**
 * Created by chenjia on 2018/5/24.
 */

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author chenjia
 * @create 2018-05-24 11:03
 * @desc 接受消息
 **/
@Service(value = "consumerService")
public class ConsumerServiceImpl  implements ConsumerService{

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    public void receive(Destination destination){
         Message receiveMessage = jmsTemplate.receive(destination);
         try {
             System.out.println(Thread.currentThread().getName()+"接受到的消息: "+((TextMessage)receiveMessage).getText());
         }catch (Exception e){
             System.out.println(e.getMessage());
         }
    }

}
