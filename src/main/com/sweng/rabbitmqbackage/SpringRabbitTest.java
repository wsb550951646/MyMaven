package sweng.rabbitmqbackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/112:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SpringRabbitTest  extends AbstractJUnit4SpringContextTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void sendMessage(){

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("version", "2.6.0.22");
        hashMap.put("message", "hello Spring RabbitMq");
        hashMap.put("timstp", "00.00.01");

        //由于bean绑定了exchang 只需要设置routingKey即可
        amqpTemplate.convertAndSend("queueTestKey", hashMap);
    }




}
