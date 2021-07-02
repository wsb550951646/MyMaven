package sweng.Test.RabbitMq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/2/2616:53
 *
 *  RbbitMq 广播队列
 */
public class RabbitMqFanoutQueue {

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

          广播式交换机：

            Fanout类型的Ex，不需要通过routingKey去匹配消息应该分配到那个队列。

            Ex类型是Fanout，然后队列去绑定了改Ex。则发送的消息都会被这些队列接收。


     */

    @Test
    public void producter() throws IOException, TimeoutException {


        Connection connection = RabbitMqFanoutQueue.getConnect();

        Channel channel = connection.createChannel();

        //若没创建过 交换机则要先创建交换机   队列可以不用申请
        String EX_NAME = "fanoutEx";

        channel.exchangeDeclare(EX_NAME, BuiltinExchangeType.FANOUT);

        //直接把消息推到交换机中去
        for (int i = 0; i < 10; i++) {
            String message = "Hello FanOut "+i;
            channel.basicPublish(EX_NAME, "", null, message.getBytes("UTF-8"));
        }

        channel.close();
        connection.close();

    }



    @Test
    public void consumer() throws IOException, TimeoutException, InterruptedException {

        final Connection connection = RabbitMqFanoutQueue.getConnect();
        final Channel channel = connection.createChannel();

        String QUE_NAME = "fanoutQue1";
        String EX_NAME = "fanoutEx";

        channel.basicQos(1);
        //定义队列的名称
        channel.queueDeclare(QUE_NAME, true, false, false, null);

        //定义ex的名称和类型
        channel.exchangeDeclare(EX_NAME, BuiltinExchangeType.FANOUT);

        //开始绑定队列和exchange   队列          交换机     路由键
        channel.queueBind(QUE_NAME, EX_NAME, "");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("consumer1 received message:"+message);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUE_NAME, false, consumer);

        Thread.sleep(100000);


    }

    @Test
    public void consumer2() throws IOException, TimeoutException, InterruptedException {
        final Connection connection = RabbitMqFanoutQueue.getConnect();
        final Channel channel = connection.createChannel();

        String QUE_NAME = "fanoutQue2";
        String EX_NAME = "fanoutEx";

        channel.basicQos(1);

        //定义队列的名称
        channel.queueDeclare(QUE_NAME, true, false, false, null);

        //定义ex的名称和类型
        channel.exchangeDeclare(EX_NAME, BuiltinExchangeType.FANOUT);

        //开始绑定队列和exchange   队列          交换机     路由键
        channel.queueBind(QUE_NAME, EX_NAME, "");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("consumer1 received message:"+message);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUE_NAME, false, consumer);


        Thread.sleep(100000);

    }


}
