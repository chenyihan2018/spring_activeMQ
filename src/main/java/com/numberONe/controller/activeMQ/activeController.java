package com.numberONe.controller.activeMQ;/**
 * Created by chenjia on 2018/5/24.
 */

import com.numberONe.controller.index.BaseController;
import com.numberONe.service.ConsumerService;
import com.numberONe.service.ProducerService;
import com.numberONe.service.ProducerServiceImpl;
import com.numberONe.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author chenjia
 * @create 2018-05-24 10:52
 * @desc
 **/
@Controller
@RequestMapping("/activeMQ/")
public class activeController{

    @Autowired
    @Qualifier(value = "demoQueueDestination")
    private Destination destination;

    @Autowired
    private ProducerServiceImpl producerService;

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("send")
    public String send(String msg){
        System.out.println(Thread.currentThread().getName() + "send to JMS start");
        producerService.sendMessage(msg);
        return Common.BACKGROUND_PATH + "/system/log/list";
    }

    @RequestMapping("recive")
    public String recive(){
        System.out.println(Thread.currentThread().getName() + "recive to JSM end");
        consumerService.receive(destination);
        return Common.BACKGROUND_PATH + "/system/log/list";
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        System.out.println("123213145644444444444");
        System.out.println(Thread.currentThread().getName() + "recive to JSM end");
        return Common.BACKGROUND_PATH + "/system/log/list";
    }

}
