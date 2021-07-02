package sweng.Test.TestXml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/7/1017:17
 */
public class LearnXml {

    private String ConfigPath = "D:\\MyMaven2\\src\\main\\config\\config.xml";

    public Document init(){


        Document ret = null;
        SAXReader saxReader = new SAXReader();
        try {
            ret = saxReader.read(new File(ConfigPath));
            return ret;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Test
    public void testPath(){

        String jarPath = LearnXml.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        System.out.println(jarPath);

        String classpath = this.getClass().getResource("/").getPath();
        System.out.println(classpath);

        String resource = this.getClass().getResource("/").getPath().replaceFirst("/", "");
        System.out.println(resource);
        String web = resource+"/WEB-INF/web.xml";

        Document doc = null;
        SAXReader saxReader = new SAXReader();
        try {
            doc = saxReader.read(new File(web));
        }catch (Exception e){

        }

        Document document = doc.getDocument();
       // NodeList list = (NodeList) document.selectNodes("context-param");

    }

    @Test
    public void exe(){

        float x = 30000;
        float y = 1001;
        float re = x/y;
        Long xl = (long)-1;
        Long x2 = (long)100000;

        BigDecimal bigDecimal = BigDecimal.valueOf(0, -4);
        System.out.println(bigDecimal);

        String s = millisecond2hhmmssmmm(xl / x2);
        System.out.println(s);

    }

    public static Long hhmmssmmm2Millisecond(String hmsm) {
        if(hmsm == null) return Long.valueOf(-1);

        String[] timeArr = hmsm.split(":");
        if(timeArr == null || timeArr.length < 4) return Long.valueOf(-1);

        Long hour = Long.parseLong(timeArr[0]);
        Long minute = Long.parseLong(timeArr[1]);
        Long second = Long.parseLong(timeArr[2]);
        Long millisecond = Long.parseLong(timeArr[3]);

        Long ms = (hour*3600 + minute*60 + second)*1000 + millisecond;
        return ms;
    }

    public static String millisecond2hhmmssmmm(Long ms) {
        if(ms == null) return null;

        Long hour = ms / 3600000;
        Long remain = ms % 3600000;
        Long minute = remain / 60000;
        remain = remain % 60000;
        Long second = remain / 1000;
        Long millisecond = remain % 1000;

        String hmsm = String.format("%d:%d:%d:%d", hour, minute, second, millisecond);
        return hmsm;
    }


    @Test
    public void testXMl(){

        String resource = this.getClass().getResource("/").getPath().replaceFirst("/", "");
        System.out.println(resource);
        String web = resource+"WEB-INF/web.xml";
        System.out.println(web);

        DocumentBuilderFactory fac= DocumentBuilderFactory.newInstance();
        DocumentBuilder builder= null;
        org.w3c.dom.Document doc = null;
        String ret = null;
        try {
            builder = fac.newDocumentBuilder();
            //doc=builder.parse(web);
            doc = builder.parse(new File("D:\\MyMaven2\\target\\classes\\WEB-INF\\web.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

   //     Element documentElement = doc.getDocumentElement();
        NodeList nodeList = doc.getElementsByTagName("sseq");
        Node targetItm = null;
        boolean found = false;

        //first child
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            Node firstChild = item.getFirstChild();
            String localName = firstChild.getLocalName();//localname
            String nodeName = firstChild.getNodeName();//nodename : name
            String nodeValue = firstChild.getNodeValue();//nodevalue
            String textContent = firstChild.getTextContent();//textcontent    : xxx
            System.out.println("localname:"+localName +" nodename:"+nodeName+" nodevalue:"+nodeValue+" textContent:"+textContent+"");

        }



        //child
        NodeList childNodes1 = nodeList.item(0).getChildNodes();
        for (int i = 0; i <childNodes1.getLength() ; i++) {

            Node item = childNodes1.item(i);
            short nodeType = item.getNodeType();    //nodetype
            String localName = item.getLocalName();//localname
            String nodeName = item.getNodeName();//nodename : name
            String nodeValue = item.getNodeValue();//nodevalue
            String textContent = item.getTextContent();//textcontent    : xxx
            NodeList childNodes = item.getChildNodes();


            System.out.println("childenodes:"+(childNodes==null?"null":childNodes.getLength())+"nodetype:"+nodeType+"localname:"+localName +" nodename:"+nodeName+" nodevalue:"+nodeValue+" textContent:"+textContent+"");

        }


        //NodeName、LocalName 、 NodeValue 、 TextContent
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            if(item.getNodeType() == Node.ATTRIBUTE_NODE){
                String localName = item.getLocalName();
                String nodeName = item.getNodeName();
                String textContent = item.getTextContent();
                String nodeValue = item.getNodeValue();


                NamedNodeMap attributes = item.getAttributes();
                Node xmlns = attributes.getNamedItem("folder");
                xmlns.getNodeValue();
                xmlns.getTextContent();
                xmlns.getNodeName();
                xmlns.getLocalName();
            }else if (item.getNodeType() == Node.ELEMENT_NODE){
                String localName = item.getLocalName();
                String nodeName = item.getNodeName();
                String textContent = item.getTextContent();
                String nodeValue = item.getNodeValue();
                NamedNodeMap attributes = item.getAttributes();
                Node xmlns = attributes.getNamedItem("folder");
                xmlns.getNodeValue();
                xmlns.getTextContent();
                xmlns.getNodeName();
                xmlns.getLocalName();
            }

        }


        for (int i = 0; i < nodeList.getLength(); i++) {
            targetItm = nodeList.item(i);
            Node firstChild = targetItm.getFirstChild();
            System.out.println(firstChild.getNodeValue());
            if(firstChild!=null && firstChild.getNodeValue().equals("contextConfigLocation")){
                found=true;
                break;
            }
        }
        if(found){
            NodeList childNodes = targetItm.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if(item.getNodeName().equals("param-value"))
                    ret = item.getNodeValue();
            }
        }
        System.out.println(ret);



    }

    @Test
    public void UseXmlMethod(){

        /*
            XMl的4中形式
            Element      指的是节点<name>xiao</name>  该节点
            Attribute    指节点里面的属性<name vale="xx">xiao</name>  表示vale为属性
            Text         指节点里的值Xiao
         */
        Document doc = init();

        //获得节点
        //doc.selectNodes("/Company/Department")


    }

}
