package sweng.MonitorPackage.Agent;

import sweng.MonitorPackage.Data.MonitorData;
import sweng.MonitorPackage.Manager.MonitorDataDispatch;
import sweng.MonitorPackage.entry.MonitorEntry;

import javax.management.monitor.Monitor;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1019:41
 */
public abstract class AbstractMonitorAgent implements MonitorAgent {

    private MonitorEntry entry;
    private MonitorDataDispatch monitorDataDispatch;

    public AbstractMonitorAgent(MonitorEntry entry) {
        this.entry = entry;
    }

    @Override
    public void setDataDispatcher(MonitorDataDispatch dataDispatcher) {
        monitorDataDispatch = dataDispatcher;
    }

    public MonitorEntry getEntry() {
        return entry;
    }

    protected void dispatche(Object value) {
        dispatche(null, value);
    }



    /*
        分配将传入index 和value填充到data中。
        调用MonitorDataDispatch的分配，将monitorEntry 和 monitorData绑定
     */
    protected void dispatche(String index,Object value){
        MonitorData monitorData = new MonitorData();
        monitorData.setTimestamp(System.currentTimeMillis());
        monitorData.setIndex(index);
        monitorData.setData(value.toString());
        monitorData.setCode(entry.getCode());
        //monitorData.setHost(entry.);
        monitorDataDispatch.dispatch(entry, monitorData);
    }
}
