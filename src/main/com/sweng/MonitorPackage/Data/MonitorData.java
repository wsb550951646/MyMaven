package sweng.MonitorPackage.Data;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1019:45
 */
public class MonitorData {

    private long timestamp;
    private String host;
    private String code;
    private String index;
    private String data;

    public MonitorData(long timestamp, String host, String code, String index, String data) {
        this.timestamp = timestamp;
        this.host = host;
        this.code = code;
        this.index = index;
        this.data = data;
    }

    public MonitorData() {
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
