package sweng.Test.RabbitMq;

import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.AMQBasicProperties;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/2/289:34
 *
 *  首部先换机Headers
 *
 */
public class RabbitMqHead {

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
        首部交换机Header：

            和topic扇形交换机一样，不需要routingKey去绑定消息。通过首部Header的key-value值去匹配

            有两种匹配方式 any 和 all。 any：是任意一个key-value 相等， all:需要所以属性相等

            客户端设置的Head的Hash添加到AMQ.properties.header的属性中去

            服务端设置的Hash值（带x-match:any 或 all）的，绑定到  channel.queueBind(QUE_NAME, EX_NAME, "",hashMap);中去，关联队列和交换机

            无需要RoutingKey就可以完成分配，相对于Direct的ex， 好处是可以使用多个匹配字符，且不局限与字符串，可以是对象Object类型
     */

    @Test
    public void Producer() throws IOException, TimeoutException {

        Connection connect = RabbitMqHead.getConnect();

        Channel channel = connect.createChannel();

        String QUE_NAME = "RabbitMq.Head.Que";

        String EX_NAME = "RabbitMq.Head.Ex";

        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("api", "login");
        hashMap.put("version", "2.5");
        hashMap.put("uuid", UUID.randomUUID().toString());

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().headers(hashMap).build();

        String message = "Hello Head Exchange";
        channel.basicPublish(EX_NAME,"" , properties,message.getBytes("UTF-8"));

        channel.close();
        connect.close();


    }

    @Test
    public void Consumer() throws IOException, TimeoutException, InterruptedException {

        Connection connect = RabbitMqHead.getConnect();

        final Channel channel = connect.createChannel();

        String QUE_NAME = "RabbitMq.Head.Que";

        String EX_NAME = "RabbitMq.Head.Ex";

        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("x-match", "all");
        hashMap.put("api", "login");
        hashMap.put("uuid", UUID.randomUUID().toString());
        hashMap.put("version", "2.5");

        channel.queueDeclare(QUE_NAME, true, false, false,null);

        channel.exchangeDeclare(EX_NAME, BuiltinExchangeType.HEADERS);

        channel.queueBind(QUE_NAME, EX_NAME, "",hashMap);

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body,"UTF-8");
                System.out.println("消费者接受到 message："+message);
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };
        channel.basicConsume(QUE_NAME, false, consumer);

        Thread.sleep(10000);

    }




}
