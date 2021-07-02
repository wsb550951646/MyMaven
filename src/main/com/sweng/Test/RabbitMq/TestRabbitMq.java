package sweng.Test.RabbitMq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/2/2613:18
 */
public class TestRabbitMq {



    public static Connection getConnect() throws IOException, TimeoutException {

        Connection connection = null;
        //创建连接的工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setPort(AMQP.PROTOCOL.PORT);//5672
        factory.setHost("127.0.0.1");
        factory.setUsername("guest");
        factory.setPassword("guest");

        //建立一个长连接
         connection = factory.newConnection();

         return connection;
    }

    public static Channel getChannel() throws IOException, TimeoutException {

            Connection connect = getConnect();
            Channel channel = connect.createChannel();
            System.out.println("new Channel");
            return channel;

    }

    @Test
    public void testBasicPublish() throws IOException, TimeoutException {

        //建立一个长连接
        Connection connection = TestRabbitMq.getConnect();

        //创建一个通道
        Channel channel =connection.createChannel();


        String QUE_NAME = "te";
        String EX_NAME = "exchange";
        String RO_NAME = "rout1";

        /*
        1.表示队列名称、
        2.是否持久化（true表示是，队列将在服务器重启时生存）、
        3.是否是独占队列（创建者可以使用的私有队列，断开后自动删除）、
        4.为当所有消费者客户端连接断开时是否自动删除队列、
        5.队列的其他参数

         */
        //声明一个队列
        //channel.queueDeclare(QUE_NAME,false ,false , false, null);

        //声明一个交换机  指定名称和交换机的类型
        //channel.exchangeDeclare(EX_NAME,BuiltinExchangeType.DIRECT);

        //队列绑定路由键  和交换机
        //channel.queueBind(QUE_NAME, EX_NAME,RO_NAME);

        //发送消息到队列里面
        String message = "My first RabbitMq Message";
        // 注意：exchange如果不需要写成空字符串，routingKey和队列名称保持一致

        /*
        1.系统会为每个队列都隐式的绑定一个默认的交换机，交换机的名称为“(AMQP default)",类型为直连接direct
        2.当你手动创建一个队列时，后台会自动将这个队列绑定到一个名称为空的Direct类型交换机上，绑定路由名称与队列名称相同
        例如：channel.queueBind(queue:“QUEUE_NAME”, exchange:"(AMQP default)", routingKey:“QUEUE_NAME”);

         channel.basicPublish("", QUE_NAME, null, message.getBytes("UTF-8"));

            参数1：交换机的名称 参数2：队列的名称  参数3：？ 参数4：编码格式

         */

        //消息的发布是在  发布到交换机上的   然后交换机在发布到绑定路由键的队列上！！！
        channel.basicPublish(EX_NAME, RO_NAME,null, message.getBytes());
        System.out.println("Send Message:" + message);

        channel.close();
        connection.close();

    }

    @Test
    public void testBasicConsumerNoAuto() throws IOException, TimeoutException {

        Connection connect = TestRabbitMq.getConnect();

        final Channel channel = connect.createChannel();

        String QUE_NAME = "test1";

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body);
                System.out.println("receive message:"+message);
                //手动应答
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };

        System.out.println("QUE:"+QUE_NAME);
        channel.basicConsume(QUE_NAME, false, consumer);

        channel.close();
        connect.close();


    }


    @Test
    public void testBasicConsumer() throws IOException, TimeoutException {

        //建立一个长连接
       Connection connection = TestRabbitMq.getConnect();

        //创建一个通道
        Channel channel = connection.createChannel();

        //声明一个队列
        String QUE_NAME = "te";
        //channel.queueDeclare(QUE_NAME, false, false, false, null);
        System.out.println("Consumer Wating Receive Message");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println(" [C] Received '" + message + "'");
            }
        };

        /*关于basicConsume的第二个参数autoAck: 应答模式
        true：自动应答，即消费者获取到消息，该消息就会从队列中删除掉
        false：手动应答，当从队列中取出消息后，需要程序员手动调用方法应答，
        如果没有应答，该消息还会再放进队列中，就会出现该消息一直没有被消费掉的现象
         */
        channel.basicConsume(QUE_NAME, true, consumer);


    }

}
