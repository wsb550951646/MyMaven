package sweng.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/309:48
 */
public class SysTestParam {

    public static final String TYPE_PREDEFINE = "preset";
    public static final String TYPE_SINGLE = "single";
    public static final String TYPE_LIST = "list";
    public static final String TYPE_SEQUENCE = "sequence";

    @XmlAttribute(name = "type")
    private String type;

    @XmlElement
    private String name;

    @XmlElementWrapper(name = "values")
    @XmlElements(@XmlElement(name = "value",type = SysTestParamValue.class))
    private List<SysTestParamValue> values;

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
    public List<SysTestParamValue> getValues() {
        return values;
    }

    public void setValues(List<SysTestParamValue> values) {
        this.values = values;
    }
}
