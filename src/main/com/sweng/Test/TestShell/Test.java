package sweng.Test.TestShell;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/5/2018:23
 */
public class Test {

    @org.junit.Test
    public  void test1() throws Exception{
        String[] cmds = {"/bin/sh","-c","ps -ef|grep java"};
        Process pro = Runtime.getRuntime().exec(cmds);
        pro.waitFor();
        InputStream in = pro.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while((line = read.readLine())!=null){
            System.out.println(line);
        }
    }

    @org.junit.Test
    public void test2(){

        HashMap<String, String> map = new HashMap<>();
        map.put("11", "123");

        HashMap<String, String> map2 = new HashMap<>();
        map2.putAll(map);
        //map2 = map;
        System.out.println("1:"+map.get("11"));
        System.out.println("2:"+map2.get("11"));

        map.put("11", "000");
        System.out.println("1-1:"+map.get("11"));
        System.out.println("2-2:"+map2.get("11"));

    }

}
