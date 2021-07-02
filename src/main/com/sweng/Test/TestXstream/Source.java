package sweng.Test.TestXstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/9/1017:02
 */
@XStreamAlias("Source")
public class Source {

    public Source() {
    }

    public Source(String name, String IP) {
        Name = name;
        this.IP = IP;
    }

    @XStreamAlias("Name")
    private String  Name;
    @XStreamAlias("IP")
    private String  IP;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    @Override
    public String toString() {
        return "Source{" +
                "Name='" + Name + '\'' +
                ", IP='" + IP + '\'' +
                '}';
    }
}
