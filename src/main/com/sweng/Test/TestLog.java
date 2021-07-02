package sweng.Test;

import org.apache.log4j.Logger;
import org.junit.Test;
import sweng.bean.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/614:07
 */
public class TestLog {
    private static Logger logger = Logger.getLogger(TestLog.class);

    private final static String STATIC_FILL_F = "ffff";
    private final static String STATIC_FILL_O = "0000";

    @Test
    public void testcopy() throws IOException {

        File source = new File("C:\\Users\\sweng.ARCVIDEO\\Desktop\\x.ts.pic");
        File target = new File("C:\\Users\\sweng.ARCVIDEO\\Desktop\\2.m3u8.pic");
        System.out.println(source.getAbsolutePath());

        File[] files = source.listFiles();
        for(File f : files){
            org.apache.commons.io.FileUtils.copyFile(f,new File(target, f.getName()));
        }


    }

    @Test
    public void teststr(){

        String x = "s3://AKIAIOSFODNN7EXAMPLE:wJalrXUtnFEMIK7MDENGbPxRfiCYEXAMPLEKEY@172.17.229.217:9000/sweng/1.ts";

        String y = "/172.17.229.217:9000/sweng";

        y.substring(0, 2);
        System.out.println(y);

        test333(y);
        System.out.println(y);

        String x1 = "testadfafadftest";
        String replace = x1.replace("test", "x");
        System.out.println("result  =="+replace);
        String test = x1.replaceFirst("test", "x");
        System.out.println("result2  =="+test);
        boolean contains = x.contains(y);
        System.out.println(contains);


    }
    public void test333(String x){
        x.substring(0, 2);
    }

    @Test
    public void getfloat(){

        String value = "0.33";
        float v = Float.parseFloat(value);
        System.out.println(v);

    }

    @Test
    public void format(){
        String fromat = "%1$-5s\t%2$-9s\t[%3$s]\t%4$s";
        String test = "xxxxxxxx";
        String[] test1 = {"11","22","33","44"};
       // System.out.println(String.format(fromat,test ));
        System.out.println(String.format(fromat,test1[0],test1[1],test1[2],test1[3]));

    }

    @Test
    public void IntegerNull(){

        Integer integer = null;
        String s = String.valueOf(integer);
        System.out.println(s);
    }


    @Test
    public void TestListRemoveMethod(){

        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("Jack");
        user.setPassword("1");

        User user1 = new User();
        user1.setId(1);
        user1.setName("King");
        user1.setPassword("1");

        users.add(user);
        users.add(user1);

        User user2 = new User();
        user2.setId(1);

        users.remove(user1);
        System.out.println(users);

    }

    @Test
    public void TestLinkedListSet(){

        LinkedList<String> list = new LinkedList<>();
        list.add("Jack");
        list.add("Que");
        list.add("king");
        list.add("MM");

        list.set(0, "Wang");

        System.out.println(list);


    }

    @Test
    public void test16x(){

        Integer i = 1244;
        boolean open =false;
        if(open){
            String s = Integer.toHexString(i);
            System.out.println("high :"+s);
            String result = HexFillHighLetter(s,"f");
            System.out.println("result:"+(result+STATIC_FILL_F));
        }else
        {
            String s = Integer.toHexString(i);
            System.out.println("low :"+s);
            String result = HexFillHighLetter(s, "0");
            System.out.println("result:"+(STATIC_FILL_F+result));
        }

    }

    @Test
    public void test_StringFormat(){

        Integer i = 1;

        String format = String.format("%04d", i);

        System.out.println(format);

    }

    public String HexFillHighLetter(String hex,String fill){

        if(fill.equalsIgnoreCase("0")|| fill.equalsIgnoreCase("F")){
            if(hex.length()>3)
                return hex;
            if(hex.length()>2)
                return fill+hex;
            if(hex.length()>1)
                return fill+fill+hex;
            if(hex.length()>0)
                return fill+fill+fill+hex;
        }
        return "";
    }

    @Test
    public void TestLog(){

        Integer o = 129;
        Integer x = 129;

        if(o.intValue() == x.intValue())
            System.out.println("intvalue");

        if(o.equals(x))
            System.out.println("1....");

        if(o==x)
            System.out.println("--");

        String value = "123";
        System.out.println("---");
        int i = value.indexOf("2", 0);
        System.out.println(i);
        //[0,1)  裁剪的作用
        String substring = value.substring(0, i);
        System.out.println(substring);
        System.out.println("--");
        String s = value.replaceAll("%", ".*");

        System.out.println(s);

        logger.debug(" This is debug!!!");
        logger.info(" This is info!!!");
        logger.warn(" This is warn!!!");
        logger.error(" This is error!!!");
        logger.fatal(" This is fatal!!!");
    }


    @Test
    public void test(){

        String Mode = "";
        ArrayList<String> audioList = new ArrayList<>();
        int j = 0;
        Integer audioNumber = 0;

        //是用If 和 else 使用

        //所有
        if(Mode.equalsIgnoreCase("0")){

            for (int i = 0; i < audioList.size(); i++) {
                //执行完成
            }
        }else if(Mode.equalsIgnoreCase("1")){
            for (int i = 0; i < audioList.size(); i++) {
                if(audioNumber.equals(i+1)){
                    //执行
                }
            }
        }

        for (int i = 0; i < audioList.size(); i++) {
            if(audioNumber.equals(0) == false && audioNumber.equals(i+1))
                continue;

            //执行任务
        }





    }

}
