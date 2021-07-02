package sweng.bean;

import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/714:47
 */
public class ServerGroup {

    public static final int TYPE_DEFAULT = 0;
    /**
     * Indicate this group is transcoder group.
     */
    public static final int TYPE_CLOUD_TRANSCODER = 2;
    /**
     * Indicate this group is merget group.
     */
    public static final int TYPE_CLOUD_MERGER = 3;
    /**
     * Indicate this group without share feature.
     */
    public static final int SHARE_TYPE_NONE = 0;
    /**
     * Indicate this group's servers can be used by other groups in certain condition.
     */
    public static final int SHARE_TYPE_PRODUCER = 1;
    /**
     * Indicate this group's tasks can executed in shared group servers.
     */
    public static final int SHARE_TYPE_CONSUMER = 2;

    private Integer id;
    private String name;
    private Integer type;
    private transient List<Server> servers;
    private Integer shareType;
    private Time startShareTime;
    private Time endShareTime;

    //private GroupTranscodingOptions transcodingOptions = new GroupTranscodingOptions();

    private List<Storage> storages = new LinkedList<Storage>();

    //private List<FtpEncodingInfo> ftpEncodingList = new LinkedList<FtpEncodingInfo>();

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }


    public void setType(Integer type) {
        this.type = type;
    }


    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }


    public Integer getShareType() {
        return shareType;
    }


    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }


    public Time getStartShareTime() {
        return startShareTime;
    }


    public void setStartShareTime(Time startShareTime) {
        this.startShareTime = startShareTime;
    }


    public Time getEndShareTime() {
        return endShareTime;
    }


    public void setEndShareTime(Time endShareTime) {
        this.endShareTime = endShareTime;
    }


    public List<Storage> getStorages() {
        return storages;
    }

    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }

}
