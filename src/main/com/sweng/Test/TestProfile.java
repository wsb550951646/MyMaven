package sweng.Test;

import sweng.bean.TestActiveProfile;
import org.junit.Test;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/1317:24
 */
public class TestProfile {

    @Test
    public void test(){

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //TestActiveProfile testProfile = (TestActiveProfile)applicationContext.getBean("TestProfile");
        //System.out.println(testProfile.getName());

        //Object defaultUserDao = applicationContext.getBean("DefaultUserDao");
        //System.out.println(defaultUserDao);

    }


}
