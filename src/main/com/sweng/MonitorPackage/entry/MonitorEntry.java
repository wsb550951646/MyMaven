package sweng.MonitorPackage.entry;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1019:21
 */
public class MonitorEntry {

    private String code;
    private String index;
    private Long interval;
    private boolean isGroup;
    private String service;

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

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
