package sweng.rabbitmqbackage;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/112:07
 */
public class MessageConsumer implements MessageListener {


    //bean类设置好了 接收的队列

    @Override
    public void onMessage(Message message) {
        System.out.println("------------------------");
        System.out.println("received :"+message);
        System.out.println("------------------------");
    }
}
