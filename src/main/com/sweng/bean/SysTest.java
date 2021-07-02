package sweng.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/2615:08
 */
public class SysTest {

    public static final String OP_EQ = "==";
    public static final String OP_NE = "!=";
    public static final String OP_GT = ">";
    public static final String OP_GTE = ">=";
    public static final String OP_LT = "<";
    public static final String OP_LTE = "<=";

    @XmlElement
    private Integer id;
    @XmlElement
    private String type;
    @XmlElement
    private String name;
    @XmlElement
    private String description;
    @XmlElement
    private Boolean disable;
    @XmlElement
    private String node = "a";
    @XmlElement
    private String command;
    @XmlElement
    private Integer timeout;
    @XmlElement
    private String condition;
    @XmlElement
    private String info;

    @XmlElementWrapper(name = "params")
    @XmlElements(@XmlElement(name = "param",type = SysTestParam.class))
    private List<SysTestParam> params;

    private String conditionOp;
    private Float conditionValue;

    @XmlTransient
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    @XmlTransient
    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @XmlTransient
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @XmlTransient
    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    @XmlTransient
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @XmlTransient
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @XmlTransient
    public List<SysTestParam> getParams() {
        return params;
    }

    public void setParams(List<SysTestParam> params) {
        this.params = params;
    }

    public String getConditionOp() {
        return conditionOp;
    }

    public void setConditionOp(String conditionOp) {
        this.conditionOp = conditionOp;
    }

    public Float getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(Float conditionValue) {
        this.conditionValue = conditionValue;
    }

    @Override
    public String toString() {
        return "SysTest{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", disable=" + disable +
                ", node='" + node + '\'' +
                ", command='" + command + '\'' +
                ", timeout=" + timeout +
                ", condition='" + condition + '\'' +
                ", info='" + info + '\'' +
                ", params=" + params +
                ", conditionOp='" + conditionOp + '\'' +
                ", conditionValue=" + conditionValue +
                '}';
    }
}
