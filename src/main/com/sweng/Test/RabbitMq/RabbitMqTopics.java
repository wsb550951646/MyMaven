package sweng.Test.RabbitMq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/2/2713:32
 *
 *
 *  主题交换机，通过rout路由键的模糊配置，分发任务
 *
 */
public class RabbitMqTopics {



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
        生产者想 Rabbit.Topic 通道中发消息，不关心队列名称

     */
    @Test
    public void Producer() throws IOException, TimeoutException {

        Connection connect = RabbitMqTopics.getConnect();

        Channel channel = connect.createChannel();

        String EX_NAME = "Rabbit.Topics";


        // *可以代替一个单词   #可以代替0或者更多个单词
        String[] routeKeys = {"Rabbit.Top.key1","Rabbit.Top.key2","Rabbit.Top.key.test","Mq.Top.key1","Mq.Top.key2"};

        for (String routeKey : routeKeys){

            String message = "Hello Message by -"+routeKey;
            channel.basicPublish(EX_NAME,routeKey , null, message.getBytes("UTF-8"));
        }

        channel.close();
        connect.close();

    }

    /*

        消费者1使用通道1 然后模糊绑定路由键

        从结果看出：消费者1 只能接受到通道1，且路由键绑定了Rabbit.Top.# 相关的消息

     */

    @Test
    public void Consumer() throws IOException, TimeoutException, InterruptedException {

        Connection connect = RabbitMqTopics.getConnect();

        Channel channel = connect.createChannel();

        channel.basicQos(1);

        String QUE_NAME = "Rabbit.TOPIC.QUE1";

        String EX_NAME = "Rabbit.Topics";

        //配置Topic类型的路由
        channel.exchangeDeclare(EX_NAME, BuiltinExchangeType.TOPIC);

        channel.queueDeclare(QUE_NAME, true, false, false, null);

        String[] routeKeys = {"Rabbit.Top.#"};

        for (String routeKey : routeKeys){
            channel.queueBind(QUE_NAME, EX_NAME, routeKey);
        }

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body,"UTF-8");
                System.out.println("消费者1 处理任务中："+message);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        channel.basicConsume(QUE_NAME, true, consumer);

        Thread.sleep(1000000);

    }

    /*
        消费者2使用通道2，模糊绑定路由键

         从结果看出：消费者1 只能接受到通道2，且路由键绑定了Mq.Top.* 相关的消息

     */

    @Test
    public void Consumer2() throws IOException, TimeoutException, InterruptedException {

        Connection connect = RabbitMqTopics.getConnect();

        Channel channel = connect.createChannel();

        channel.basicQos(1);

        String QUE_NAME = "Rabbit.TOPIC.QUE2";

        String EX_NAME = "Rabbit.Topics";

        //配置Topic类型的路由
        channel.exchangeDeclare(EX_NAME, BuiltinExchangeType.TOPIC);

        channel.queueDeclare(QUE_NAME, true, false, false, null);

        String[] routeKeys = {"Mq.Top.*"};

        for (String routeKey : routeKeys){
            channel.queueBind(QUE_NAME, EX_NAME, routeKey);
        }

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body,"UTF-8");
                System.out.println("消费者2 处理任务中："+message);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        channel.basicConsume(QUE_NAME, true, consumer);

        Thread.sleep(1000000);

    }


}
