package com.numberONe.task;/**
 * Created by chenjia on 2018/5/21.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author chenjia
 * @create 2018-05-21 9:43
 * @desc
 **/
public class HelloQuartzTest implements Job{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("定时任务启动");
        logger.info("时间是:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
