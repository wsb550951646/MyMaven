package sweng.Test.TestEventObject;

import java.util.EventObject;

/**
 * @Description:
 *
 *  该Dns是事件，含有一些事件属性，继承EventObject 类
 *
 * @Author: swengcode
 * @Date: 2020/8/3015:31
 */
public class DnsEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */

    private String userData;
    private int    time;

    public DnsEvent(Object source) {
        super(source);
    }

    public DnsEvent(Object source, String userData, int time) {
        super(source);
        this.userData = userData;
        this.time = time;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
