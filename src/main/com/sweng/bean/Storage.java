package sweng.bean;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/714:43
 */
public class Storage {

    @XmlElement
    private Integer id;
    @XmlElement
    private String name;
    @XmlElement
    private String path;
    @XmlElement
    private String type;
    @XmlElement
    private String user;
    @XmlElement
    private String pwd;
    @XmlElement
    private String options = "";
    // the actual mount status
    private boolean mounted;
    // want to mount or not
    private boolean toMounted = true;

    @XmlTransient
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null)
            this.name = name.trim();
    }

    @XmlTransient
    public String getPath() {
        return path;
    }

    @XmlTransient
    public String getUser() {
        return user;
    }

    public void setPath(String path) {
        if (path != null)
            path = path.trim().replace('\\', '/');
        this.path = path;
    }

    public void setUser(String user) {
        if (user != null)
            this.user = user.trim();
    }

    public void setPwd(String pwd) {
        if (pwd != null)
            this.pwd = pwd.trim();
    }

    @XmlTransient
    public String getPwd() {
        return pwd;
    }

    @XmlTransient
    public String getType() {
        return (type == null || type.length() == 0) ? "cifs" : type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isMounted() {
        return mounted;
    }

    public void setMounted(boolean mounted) {
        this.mounted = mounted;
    }

    public boolean isToMounted() {
        return toMounted;
    }

    public void setToMounted(boolean toMounted) {
        this.toMounted = toMounted;
    }

    @XmlTransient
    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder(11, 21);
        builder.append(name);
        builder.append(path);
        builder.append(user);
        builder.append(pwd);
        builder.append(type);
        builder.append(options);
        builder.append(toMounted);
        return builder.toHashCode();
    }

    public boolean isSame(Storage storage) {
        return name.equals(storage.getName()) && path.equals(storage.getPath()) && type.equals(storage.getType());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Storage)) {
            return false;
        }

        Storage storage = (Storage) obj;
        return name.equals(storage.getName()) && path.equals(storage.getPath()) && user.equals(storage.getUser())
                && pwd.equals(storage.getPwd()) && type.equals(storage.getType())
                && options.equals(storage.getOptions()) && (toMounted == storage.isToMounted());
    }

    public static boolean contains(Map<String,String> allmounts, Storage storage){
        if (!allmounts.containsKey(storage.getName()))
            return false;
        String p1 = allmounts.get(storage.getName());
        if (p1.endsWith("/")){
            p1 = p1.substring(0, p1.length() - 1);
        }

        String p2 = storage.getPath();
        if (p2.endsWith("/")){
            p2 = p2.substring(0, p2.length() - 1);
        }

        return p1.equals(p2);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                ", options='" + options + '\'' +
                ", mounted=" + mounted +
                ", toMounted=" + toMounted +
                '}';
    }
}
