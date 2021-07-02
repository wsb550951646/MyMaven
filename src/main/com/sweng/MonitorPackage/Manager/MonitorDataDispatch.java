package sweng.MonitorPackage.Manager;

import sweng.MonitorPackage.Data.MonitorData;
import sweng.MonitorPackage.entry.MonitorEntry;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1019:44
 */
public interface MonitorDataDispatch {

    void dispatch(MonitorEntry entry, MonitorData ...data);

}
