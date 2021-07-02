package sweng.MonitorPackage.Manager;

import sweng.MonitorPackage.Config.MonitorConfig;

import javax.management.monitor.Monitor;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1215:49
 */
public class DefaultMonitorConfigManager extends DefaultMonitorManager {

    private MonitorConfig config;
    private String configPath;

    public MonitorConfig loadConfig(String configPath){

        return null;
    }

    @Override
    public void start() {
        start(loadConfig(configPath));
    }

    public void start(MonitorConfig monitorConfig){

        //setMonitorAgentFactory();
        //setMonitorDataServices();
        //setMonitorScheduler();
        //setEntries();
        //super.start();

    }
}
