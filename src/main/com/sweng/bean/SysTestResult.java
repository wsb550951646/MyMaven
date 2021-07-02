package sweng.bean;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/2615:08
 */
public class SysTestResult {

    private Integer id;

    private Boolean result;
    private String value;
    private String info; // return the information to show

    private List<SysTestSubItem> subItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public List<SysTestSubItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(List<SysTestSubItem> subItems) {
        this.subItems = subItems;
    }

    public static class SysTestSubItem {
        private String params; // format: xxx:xxx; xxx:xxx; xxx: xxx...
        private Boolean result;
        private String value;
        private String info; // return the information to show

        public String getParams() {
            return params;
        }

        public void setParams(String params) {
            this.params = params;
        }

        public Boolean getResult() {
            return result;
        }

        public void setResult(Boolean result) {
            this.result = result;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

}
