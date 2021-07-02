package sweng.Test.RabbitMq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/2/2615:31

    RabbitMq的工作队列
 */

public class RabbitMqWorkQueue {


        @Test
        public void testBasicPublish() throws IOException, TimeoutException {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            factory.setPort(AMQP.PROTOCOL.PORT);
            factory.setUsername("guest");
            factory.setPassword("guest");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            String QUEUE_NAME = "queue.work";
            String ROUTING_KEY = "task";
            String EXCHANGE_NAME = "amqp.rabbitmqbackage.work";
            // 声明队里
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            // 声明交换机：指定交换机的名称和类型(direct)
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

            // 循环发布多条消息
            for (int i = 0; i < 20; i++){
                String message = "Hello RabbitMQ " + i;
                channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes("UTF-8"));
            }

            // 关闭资源
            channel.close();
            connection.close();
        }

    @Test
    public void testBasicConsumer1() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(AMQP.PROTOCOL.PORT);    // 5672
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        // 设置每次从队列获取消息的数量
        channel.basicQos(1);

        // 声明一个队列
        String QUEUE_NAME = "queue.work";
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println("Consumer Wating Receive Message");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                try {
                    doWork(message);
                    // 手动应答
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        // 订阅消息, false: 表示手动应答,需要手动调用basicAck()来应答
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // 睡眠是为了不让程序立即结束，这样还有机会获取第二条消息
        Thread.sleep(1000000);
    }
    private void doWork(String message) throws Exception{
        System.out.println("消费者1 [C] Received '" + message + "', 处理业务中...");
        // 模仿消费者处理业务的时间，也让其他消费者有机会获取到消息，实际开发中不需要，这里只是模拟
        Thread.sleep(1000);
    }

    @Test
    public void testBasicConsumer2() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(AMQP.PROTOCOL.PORT);    // 5672
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        // 设置每次从队列获取消息的数量
        channel.basicQos(1);

        // 声明一个队列
        String QUEUE_NAME = "queue.work";
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println("Consumer Wating Receive Message");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                try {
                    doWork2(message);
                    // 手动应答
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        // 订阅消息, false: 表示手动应答,需要手动调用basicAck()来应答
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // 睡眠是为了不让程序立即结束，这样还有机会获取第二条消息
        Thread.sleep(1000000);
    }

    private void doWork2(String message) throws Exception{
        System.out.println("消费者2 [C] Received '" + message + "', 处理业务中...");
        // 模仿消费者处理业务的时间，也让其他消费者有机会获取到消息，实际开发中不需要，这里只是模拟
        Thread.sleep(500);
    }
 }


