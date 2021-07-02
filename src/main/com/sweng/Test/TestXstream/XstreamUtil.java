package sweng.Test.TestXstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import sweng.bean.User;

import java.io.InputStream;
import java.io.Reader;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/9/1416:15
 */
public class XstreamUtil {

    private static XStream xStream = null;

    private static class LazyHolder{
        private static final XstreamUtil INSTANCE = new XstreamUtil();
    }

    static{
        if(xStream == null){
            xStream = new XStream(new XppDriver(new NoNameCoder()));
            xStream.aliasSystemAttribute(null,"class");//去掉class属性
            xStream.autodetectAnnotations(true);//自动探测注解
            xStream.ignoreUnknownElements();//忽略未知元素
            XStream.setupDefaultSecurity(xStream);  //避免出现以下警告:Security framework of XStream not initialized, XStream is probably vulnerable
        }
    }

    private XstreamUtil(){}

    /**
     * 取得XStreamUtil实例
     * @return
     */
    public static final XstreamUtil getInstance(){
        return LazyHolder.INSTANCE;
    }

    /**
     * 取得XStream
     * @return
     */
    public static XStream getXStream(){
        return xStream;
    }

    /**
     * 与XStream.setupDefaultSecurity使用，为显式类型添加安全权限，避免抛出Security framework of XStream not initialized,
     XStream is probably vulnerable异常信息
     * @param classes
     */
    public void setXStreamAllowTypes(Class[] classes){
        xStream.allowTypes(classes);
    }


    /**
     * 若使用注解,在XML字符串映射为Java实体对象时，则一定要调用此方法.
     * @param types
     */
    public void setXStremProcessAnnotations(Class[] types){
        xStream.processAnnotations(types);
    }

    /**
     *  把实体对象转换为XML字符串
     * @param pojo
     * @return
     */
    public String pojoToXml(Object pojo){
        if(null == pojo){
            return "";
        }
        try{
            String top = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n";
            String xmlStr = top+xStream.toXML(pojo);
            System.out.println("生成的xml字符串如下:"+xmlStr);
            return xmlStr;
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 从XML字符串反序列化一个对象
     * @param xmlStr
     * @return
     */
    public <T> T xmlToPojo(String xmlStr,Class<T> cls){
        if(null == xmlStr || xmlStr.length() == 0){
            return null;
        }
        try{
            T object = (T) xStream.fromXML(xmlStr);
            return object;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从XML Reader反序列化一个对象
     * @param reader
     * @return
     */
    public <T> T xmlToPojo(Reader reader, Class<T> cls){
        if(null == reader ){
            return null;
        }
        try{
            T object = (T) xStream.fromXML(reader);
            return object;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从一个XML InputStream.中反序列化一个对象
     * @param input
     * @return
     */
    public <T> T xmlToPojo(InputStream input, Class<T> cls){
        if(null == input){
            return null;
        }
        try{
            T object = (T) xStream.fromXML(input);
            return object;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
