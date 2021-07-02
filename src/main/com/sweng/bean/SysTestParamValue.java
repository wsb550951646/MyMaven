package sweng.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/309:56
 */
public class SysTestParamValue {
    public static final String TYPE_CONSTANT = "constant";
    public static final String TYPE_VARIABLE = "variable";

    @XmlElement
    private String type;
    @XmlElement
    private String name;
    @XmlElement
    private String way;

    public SysTestParamValue() {
    }

    public SysTestParamValue(String type, String name, String way) {
        this.type = type;
        this.name = name;
        this.way = way;
    }

    @XmlTransient
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}
