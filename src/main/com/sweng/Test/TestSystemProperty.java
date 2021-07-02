package sweng.Test;

import org.junit.Test;
import sweng.utils.ConfigVarsConverter;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/99:51
 */
public class TestSystemProperty {


    //使用原生的System.getProperties 去获取存放在 System的key-value值
    @Test
    public void test(){

        Properties properties = System.getProperties();

        System.setProperty("MongoTest", "123455");

        int count = 0;
        for(String proper:properties.stringPropertyNames()){

            System.out.println(proper);
            count++;
        }
        System.out.println(count);

        String mongoTest = System.getProperty("MongoTest");
        System.out.println(mongoTest);

    }
    @Test
    public void test2(){
        System.setProperty("test.id", "123456");
        System.setProperty("test.name", "myname");
        Properties p = new Properties();
        p.setProperty("info", "The ${test.id}'s name is ${test.name}");
        String expected = "The 123456's name is myname";
        String actual = ConfigVarsConverter.getProperty("info", p);
        assertEquals(expected, actual);
    }

}
