package sweng.Test.RabbitMq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/2/2813:54
 *
 *  死亡交换机  死亡路由键
 */
public class RabbitMqDeadQueue {

    public static Connection getConnect() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPort(AMQP.PROTOCOL.PORT);
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        Connection connection = connectionFactory.newConnection();
        return connection;
    }

    /*
        由于一些队列上的设置，可以使得消息有了生命周期，若在生命周期内无法处理，

        设置了死亡交互机和路由键的情况下，消息就会被防止到改死亡交换机的队列上去。


         死亡交换机和路由键：

            Dead letter exchange(x-dead-letter-exchange)：
            当队列消息长度大于最大长度、或者过期的等，将从队列中删除的消息推送到指定的交换机中去而不是丢弃掉,
            Features=DLX

            Dead letter routing key(x-dead-letter-routing-key)：
            将删除的消息推送到指定交换机的指定路由键的队列中去,
            Feature=DLK


            队列还可以通过一些参数来控制队列上的消息： 如下

            Maximum priority(x-max-priority)：
            优先级队列，声明队列时先定义最大优先级值(定义最大值一般不要太大)，在发布消息的时候指定该消息的优先级， 优先级更高（数值更大的）的消息先被消费,
            Feature=Pri
            （消息的优先级别只会影响处理的速度，不会影响发送到死信队列的顺序）

            Message TTL(x-message-ttl)：
            设置队列中的所有消息的生存周期(统一为整个队列的所有消息设置生命周期),
            也可以在发布消息的时候单独为某个消息指定剩余生存时间,单位毫秒,
            消息会被从队里中删除，注意是消息被删除，而不是队列被删除，
            Features=TTL

            Auto Expire(x-expires):
            当队列在指定的时间没有被访问(consume, basicGet, queueDeclare…)就会被删除,
            Features=Exp

            Max Length(x-max-length):
            限定队列的消息的最大值长度，超过指定长度将会把最早的几条删除掉， 类似于mongodb中的固定集合，例如保存最新的100条消息,
            Feature=Lim

            Max Length Bytes(x-max-length-bytes):
            限定队列最大占用的空间大小， 一般受限于内存、磁盘的大小,
            Features=Lim

     */

    @Test
    public void producer() throws IOException, TimeoutException {

        Connection connect = RabbitMqDeadQueue.getConnect();

        Channel channel = connect.createChannel();

        //创建死亡交换机和路由键
        String EX_DEAD_NAME = "EX_DEAD";

        String QUE_DEAD_NAME = "QUE_DEAD";

        String ROUTE_DEAD_NAME = "ROUTE_DEAD";

        channel.exchangeDeclare(EX_DEAD_NAME, BuiltinExchangeType.DIRECT);

        channel.queueDeclare(QUE_DEAD_NAME, true, false, false, null);

        channel.queueBind(QUE_DEAD_NAME, EX_DEAD_NAME, ROUTE_DEAD_NAME);

        //普通交换机、队列 对消息进行控制
        String QUE_NAME = "QUE_NORMAL";

        String EX_NAME = "EX_NORMAL";

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("x-message-ttl", 10000);
        hashMap.put("x-max-length", 4);
        hashMap.put("x-expires", 20000);
        hashMap.put("x-max-length-bytes", 10240);
        hashMap.put("x-dead-letter-exchange", EX_DEAD_NAME);
        hashMap.put("x-dead-letter-routing-key", ROUTE_DEAD_NAME);

        //在声明时队列中去配置，从而控制消息生命周期
        channel.queueDeclare(QUE_NAME, true, false, false, hashMap);

        //广播类型的，不需要路由键
        channel.exchangeDeclare(EX_NAME, BuiltinExchangeType.FANOUT);



        channel.queueBind(QUE_NAME, EX_NAME, "",null);

        for (int i = 0; i < 5; i++) {

            String message = "Hello Dead Exchange And RoutingKey "+i;
            channel.basicPublish(EX_NAME, "", null, message.getBytes("UTF-8"));

        }

        channel.close();
        connect.close();



    }


}
