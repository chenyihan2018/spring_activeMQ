/**
 * Created by chenjia on 2018/5/18.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenjia
 * @create 2018-05-18 16:35
 * @desc
 **/
public class Quarttest {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-quartz.xml");
    }
}
