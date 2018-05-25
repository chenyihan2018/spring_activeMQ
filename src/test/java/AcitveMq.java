/**
 * Created by chenjia on 2018/5/23.
 */

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenjia
 * @create 2018-05-23 17:12
 * @desc
 **/
public class AcitveMq {

    public static void main(String[] args) {
//        while (true){
//            HttpClient httpClient = new HttpClient();
//            new Thread(new Sender(httpClient)).start();
//        }
        try {
            for(int i=0;i<1000 ;i++){
                HttpClient httpClient = new HttpClient();
                System.out.println("执行了" + i);
                GetMethod post = new GetMethod("http://127.0.0.1:8080/activeMQ/send.shtml?msg=%E5%93%88%E5%93%88%E5%93%88");
                GetMethod post1 = new GetMethod("http://127.0.0.1:8080/activeMQ/recive.shtml");
                httpClient.executeMethod(post);
                httpClient.executeMethod(post1);

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
    class Sender implements Runnable {
        public static AtomicInteger count = new AtomicInteger(0);
        HttpClient httpClient;

        public Sender(HttpClient client) {
            httpClient = client;
        }

        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+"---Send message-"+count.getAndIncrement());
                PostMethod post = new PostMethod("http://127.0.0.1:8080/send.shtml");
                post.addParameter("msg", "Hello world!");
                httpClient.executeMethod(post);
                System.out.println(Thread.currentThread().getName()+"---Send message Success-"+count.getAndIncrement());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }