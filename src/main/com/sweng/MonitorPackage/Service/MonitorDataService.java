package sweng.MonitorPackage.Service;

import sweng.MonitorPackage.Data.MonitorData;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1214:21
 */
public interface MonitorDataService {

    void init(String configName);

    String getConfig();

    void process(MonitorData ... data);

    void destory();

}
