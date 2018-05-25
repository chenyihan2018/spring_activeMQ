package com.numberONe.service;/**
 * Created by chenjia on 2018/5/24.
 */

import javax.jms.Destination;

/**
 * @author chenjia
 * @create 2018-05-24 15:22
 * @desc
 **/
public interface ProducerService {

     void sendMessage(Destination destination, final String msg);

      void sendMessage(final String msg);
}
