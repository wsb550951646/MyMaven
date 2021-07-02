package sweng.Test.TestJson;


import com.alibaba.fastjson.JSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sweng.utils.http.httputils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/5/1814:36
 */
public class Test {

    @org.junit.Test
    public void x(){
        Integer x1 = 111111;
        Integer x2 = 111111;
        System.out.println(x1.equals(x2));
        System.out.println(x1==x2);


        TestObject testObject = new TestObject();
        testObject.setFilename("1");
        me(testObject);
        System.out.println(testObject.getFilename());

        Integer x = 1;
        System.out.println(x.byteValue());

    }

    public void me(TestObject object){
        object.setFilename("xxxxx");
    }


    private static final String url = "http://172.21.99.50:8989/MyMaven2/ov0/cbTransStart";
    @org.junit.Test
    public void testJson1() throws ParseException {


        JSONObject jsonObject = (JSONObject)new JSONParser().parse(updateAudioJsonString);

        System.out.println(jsonObject.toJSONString() + "\n" + jsonObject.getClass());

        //get
        Object function = jsonObject.get("FUNCTION");
        System.out.println(function);
        //put
        Object put = jsonObject.put("testName", "tset");
        jsonObject.put("FUNCTION","NEW");
        System.out.println(jsonObject.toJSONString());


        JSONObject args = (JSONObject) jsonObject.get("ARGS");
        JSONArray array = (JSONArray)args.get("AUDIOS");
        System.out.println("AUDIO:"+array.get(0));


    }

    @org.junit.Test
    public void testJson2() throws JsonProcessingException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        TestObject testObject = new TestObject();
        String format = simpleDateFormat.format(new Date());
        testObject.setDate(format);


        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(testObject);
        System.out.println(s);
    }

    @org.junit.Test
    public void testJson3() throws ParseException, UnsupportedEncodingException {

        JSONObject jsonObject = (JSONObject)new JSONParser().parse(updateAudioJsonString);

        JSONObject args = (JSONObject) jsonObject.get("ARGS");


        JSONArray audios = (JSONArray) args.get("AUDIOS");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("test","test");
        String x = "中文乱码";
        jsonObject1.put("test2",x);
        audios.add(jsonObject1);
        System.out.println(audios.toJSONString());

        httputils utils = new httputils();
        utils.httpPostWithJson(url,audios.toJSONString());



        String x1 = "中国";
        String s = null;
        try {
             s = new String(x1.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] bytes = x1.getBytes("utf-8");
        System.out.println(new String(bytes));


        s = URLEncoder.encode(x1, "UTF-8");

        //System.out.println(s);
    }

    @org.junit.Test
    public void testJson4() throws ParseException, UnsupportedEncodingException {

        JSONObject jsonObject = (JSONObject)new JSONParser().parse(updateAudioJsonString);

        JSONObject function = (JSONObject)jsonObject.get("FUNCTION");

        function.put("FUNCTION","中国");


    }

    @org.junit.Test
    public void testAlibaba(){

        String json = "{\"file_size\":123.0,\"filename\":\"t\"}";

        TestObject testObject = new TestObject();
        testObject.setFile_size(123);
        testObject.setFilename("t");
        String s = JSON.toJSONString(testObject);

        TestObject testObject1 = JSON.parseObject(json, TestObject.class);
        System.out.println(JSON.toJSONString(testObject1));


        System.out.println(s);


    }

        private String resultJsonString =
            "{\"filename\":\"\","+
                "\"filename_enconde\":\"\","+
                    "\"filename_encode_url\":\"\","+
                    "\"file_size\":\"\","+
                    "\"file_type\":\"\","+
                    "\"create_date\":\"\","+
                    "\"create_name\":\"\""+
                    "}";




    private String updateAudioJsonString = "{\"FUNCTION\": \"UPDATE\",  \"ARGS\": {"
            + "\"DREREFERENCE\": \"CDV-SYSTEM-A_582e9e15-1107-11e6-aa97-9cb654752744\","
            + "\"SOURCE_PATH\":\"\","
            + "\"AUDIOS\": ["
            + " {"
            +"\"PATH_AUDIO\": \"/date/a/1.wav\","
            +"\"SIZE_AUDIO\": \"\","
            +"\"LENGTH_AUDIO\": \"\","
            +"\"MD5\": \"\","
            +"\"FILEFORMAT\": \"1\","
            +"\"BITRATE_AUDIO\":\"\","
            +"\"TEXT_METADATA\":\"\""
            +"}"
            +"]"
            +"}"
            +"}\";";
}
