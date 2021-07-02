package sweng.MonitorPackage.Sender;

import sweng.MonitorPackage.Data.MonitorData;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1214:32
 */
public interface MonitorDataSender {

    void init(String config);

    void send(MonitorData... data);

    void destroy();


}
