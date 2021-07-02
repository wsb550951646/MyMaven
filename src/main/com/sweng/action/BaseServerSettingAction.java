package sweng.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/2615:13
 */
public class BaseServerSettingAction extends ActionSupport {
    protected Boolean Local;
    protected String id;

    public Boolean getLocal() {
        return Local;
    }

    public void setLocal(Boolean local) {
        Local = local;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
