package sweng.MonitorPackage.Agent;

import sweng.MonitorPackage.Manager.MonitorDataDispatch;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1019:34
 */
public interface MonitorAgent {

    void setDataDispatcher(MonitorDataDispatch dataDispatcher);
}
