package sweng.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/510:49
 */

@Controller
public class TestSpringMVC {

    @RequestMapping(method = RequestMethod.GET,value = "/api/hello")
    @ResponseBody
    public void hello(){
        System.out.println("-------------------");
        System.out.println("hello mvc");

    }

    @RequestMapping(method = RequestMethod.POST,value = "/ov0/cbTransStart",produces="application/json;UTF-8")
    @ResponseBody
    public void testReceivedStart(@RequestBody String message) throws UnsupportedEncodingException {

        System.out.println("-----received Start message ---");
        String s = new String(message.getBytes("ISO-8859-1"), "utf-8");
        System.out.println(message);
        System.out.println("--------end ----------");
    }

    @RequestMapping(method = RequestMethod.POST,value = "/ov0/cbTransCompleted",produces="application/json;UTF-8")
    @ResponseBody
    public void testReceivedCompleted(@RequestBody String message) throws UnsupportedEncodingException {
        System.out.println("-----received completed message ---");
        String s = new String(message.getBytes("ISO-8859-1"), "utf-8");
        System.out.println(message);
        System.out.println("--------end ----------");
    }

}
