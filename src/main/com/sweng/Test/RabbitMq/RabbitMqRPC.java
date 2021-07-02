package sweng.Test.RabbitMq;

import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.AMQBasicProperties;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/2/2714:37
 *
 *
 *  RPC应答模式
 *
 */
public class RabbitMqRPC {


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
        应答模式客户端：

        1.要发送消息给服务端的应答队列中去。其中要带连个参数replyTo 和 correlationId 两个参数

            replyTo: 指客户端的请求被服务端答复后， 返回参数放在的哪个队列中。 即返回参数的队列名称。以便客户端去订阅该队列

            correlationId：是判断该消息 是否是 我需要的答复消息，此为UUID值，作为验证。

        2. 客户端要去订阅 replyTo的队列，获取请求处理后的参数值！


        应答模式的服务端：

        1.首先要订阅应答队列，去接收服务端发送过来的请求参数。

        2.然后在应答的时候处理完消息，发送消息到replyTo的队列中去.

        需要注意的publish只关注exchange和routingKey，是无法去推送到具体队列的。但是若推送的exchange为空，则routingKey和队列名称相同。

     */

    @Test
    public void producer() throws IOException, TimeoutException, InterruptedException {

        Connection connect = RabbitMqRPC.getConnect();

        Channel channel = connect.createChannel();

        String QUE_NAME = "request.que";

        //定义回复队列 零时随机队列 消费者结束订阅则自动消失
        String reply_to_que = channel.queueDeclare().getQueue();

        final String UUID = java.util.UUID.randomUUID().toString();

        System.out.println("客户端开始监听响应信息...");
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if(properties.getCorrelationId().equalsIgnoreCase(UUID)){
                    String message = new String(body,"UTF-8");
                    System.out.println("客户端接收到服务端响应消息 message:"+message);
                }

            }
        };

        channel.basicConsume(reply_to_que, true, consumer);




        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().replyTo(reply_to_que).correlationId(UUID).build();
        System.out.println("客户端发送请求...");
        String message = "Send Request Message";
        channel.basicPublish("",QUE_NAME, properties,message.getBytes("UTF-8"));


        Thread.sleep(100000);
    }

    @Test
    public void consumer() throws IOException, TimeoutException, InterruptedException {


        Connection connect = RabbitMqRPC.getConnect();

        final Channel channel = connect.createChannel();

        String QUE_NAME = "request.que";

        //定义队列
        channel.queueDeclare(QUE_NAME,true,false,false,null);

        System.out.println("服务器开始监听客户端的请求...");
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String reply_to_que = properties.getReplyTo();
                String uuid = properties.getCorrelationId();

                String message = new String(body,"UTF-8");
                System.out.println("服务端接收到请求信息 message:"+message);

                String response = "{'code': 200, 'data': '" + message+ "'}";

                AMQP.BasicProperties AMQproperties = new AMQP.BasicProperties().builder().correlationId(uuid).build();
                System.out.println("服务端已返回响应数据...");
                channel.basicPublish("", reply_to_que, AMQproperties, response.getBytes("UTF-8"));

                //手动结束
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };

        channel.basicConsume(QUE_NAME, false, consumer);

        Thread.sleep(100000);

    }




}
