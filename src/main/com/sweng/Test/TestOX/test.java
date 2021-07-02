package sweng.Test.TestOX;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/9/2214:14
 */
public class test {

    @Test
    public void test1(){

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);

        Integer integer = integers.get(0);
        System.out.println(integer);




    }

    @Test
    public void testOX(){

        Integer x = 0x20003002;

        System.out.println(x & 0x80000000);
        if((x & 0x80000000) == 0x80000000){
            System.out.println("yes");
        }
    }

}
