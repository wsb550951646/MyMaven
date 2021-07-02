package sweng.Test.TestXstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.junit.Test;
import sweng.Test.TestXstream.mediaInfo.MediaInfo;

import java.io.InputStream;
import java.util.ArrayList;

import static java.lang.System.in;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/9/1016:54
 */
public class LearnXstream {

    @Test
    public void xml(){
        String x = "<mediaInfo name=\"http://cdn.letv-cdn.com/2018/12/05/JOCeEEUuoteFrjCg/playlist.m3u8\">\n" +
                "    <container>MPEG-TS</container>\n" +
                "    <duration>6122535</duration>\n" +
                "    <TSFormat>SPTS</TSFormat>\n" +
                "    <programs count=\"1\">\n" +
                "        <program idx=\"0\">\n" +
                "            <name>Service01</name>\n" +
                "            <used>1</used>\n" +
                "            <videos count=\"1\">\n" +
                "                <video idx=\"0\">\n" +
                "                    <pid>257</pid>\n" +
                "                    <name>Video</name>\n" +
                "                    <used>1</used>\n" +
                "                    <codec>H.264</codec>\n" +
                "                    <duration>6122535</duration>\n" +
                "                    <frameconvert>0</frameconvert>\n" +
                "                    <bitrate>0.000 kbps</bitrate>\n" +
                "                    <framerate>23.97</framerate>\n" +
                "                    <resolution>1280x720</resolution>\n" +
                "                    <aspect_ratio>16:9</aspect_ratio>\n" +
                "                    <interlacemode>Progressive</interlacemode>\n" +
                "                    <profile>0</profile>\n" +
                "                    <level>0.0</level>\n" +
                "                    <entropy>CAVLC</entropy>\n" +
                "                    <refnum>0</refnum>\n" +
                "                    <gopsize>0</gopsize>\n" +
                "                    <bframe>0</bframe>\n" +
                "                    <scantype>Progressive</scantype>\n" +
                "                </video>\n" +
                "            </videos>\n" +
                "            <audios count=\"1\">\n" +
                "                <audio idx=\"0\">\n" +
                "                    <pid>256</pid>\n" +
                "                    <name>Audio 1(und)</name>\n" +
                "                    <language>und</language>\n" +
                "                    <used>1</used>\n" +
                "                    <codec>MPEG Audio</codec>\n" +
                "                    <duration>6122535</duration>\n" +
                "                    <bitrate>128.000 kbps</bitrate>\n" +
                "                    <channel>2</channel>\n" +
                "                    <samplerate>44.100 kHz</samplerate>\n" +
                "                    <bitdepth>16</bitdepth>\n" +
                "                </audio>\n" +
                "            </audios>\n" +
                "        </program>\n" +
                "    </programs>\n" +
                "</mediaInfo>\n";
    }

    @Test
    public void toMediaInfo(){

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<mediaInfo name=\"LOCALHOST.LOCALDOMAIN (luyou-test0)\">\n" +
                "    <container>NDI</container>\n" +
                "    <video>\n" +
                "        <codec>YUV</codec>\n" +
                "        <framerate>25.00</framerate>\n" +
                "        <resolution>1920x1080</resolution>\n" +
                "    </video>\n" +
                "    <audio>\n" +
                "        <codec>PCM</codec>\n" +
                "        <channel>2</channel>\n" +
                "        <samplerate>48.000 kHz</samplerate>\n" +
                "        <bitdepth>16</bitdepth>\n" +
                "        <programnum>0</programnum>\n" +
                "        <channelinfo count=\"2\">\n" +
                "            <channel idx=\"1\">\n" +
                "                <type>PCM</type>\n" +
                "            </channel>\n" +
                "            <channel idx=\"2\">\n" +
                "                <type>PCM</type>\n" +
                "            </channel>\n" +
                "        </channelinfo>\n" +
                "    </audio>\n" +
                "</mediaInfo>\n";

        XstreamUtil instance = XstreamUtil.getInstance();
        instance.setXStreamAllowTypes(new Class[]{MediaInfo.class});
        instance.setXStremProcessAnnotations(new Class[]{MediaInfo.class});
        MediaInfo mediaInfo = instance.xmlToPojo(xml, MediaInfo.class);
        System.out.println(mediaInfo);

        String s = instance.pojoToXml(mediaInfo);
        System.out.println(s);

    }


    @Test
    public void test(){

        //InputStream in = getClass().getClassLoader().getResourceAsStream("Xstream.xml");

        String x = "1";
        int i = Integer.parseInt(x);
        System.out.println(i);

        String x1 = "";
        System.out.println("sss"+x1.length());
        //  NDISources ndiSources1 = XmlToBean(in, NDISources.class);
      //  for (Source source : ndiSources1.getSources()){
      //      System.out.println(source);
      //  }

    }

    public <T> T  XmlStreamToBean(InputStream inputStream,Class<T> object){
        try {
           XStream xStream = new XStream(new Xpp3Driver());
           xStream.processAnnotations(object);
           T o = (T) xStream.fromXML(inputStream);
           return o;
       }catch (Exception e){
           throw e;
       }
    }

    public <T> T  XmlStringToBean(String xml,Class<T> object){
        try {
            XStream xStream = new XStream(new Xpp3Driver());
            xStream.processAnnotations(object);
            T o = (T) xStream.fromXML(xml);
            return o;
        }catch (Exception e){
            throw e;
        }
    }

    @Test
    public void toXml(){

        XStream xStream = new XStream(new Xpp3Driver());
        //InputStream in = getClass().getClassLoader().getResourceAsStream("Xstream.xml");


        NDISources ndiSources1 = new NDISources();
        ArrayList<Source> sources = new ArrayList<>();


        sources.add(new Source("1","1"));
        sources.add(new Source("2","2"));
        ndiSources1.setSources(sources);

        xStream.processAnnotations(ndiSources1.getClass());

        String s = xStream.toXML(ndiSources1);
        System.out.println("s:"+s);

    }

}
