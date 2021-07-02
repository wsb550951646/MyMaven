package sweng.MonitorPackage.Manager;

import org.apache.log4j.Logger;
import sweng.MonitorPackage.Agent.DefaultMonitorFactory;
import sweng.MonitorPackage.Agent.MonitorAgent;
import sweng.MonitorPackage.Agent.MonitorAgentFactory;
import sweng.MonitorPackage.Data.MonitorData;
import sweng.MonitorPackage.Schedule.DefaultMonitorScheduler;
import sweng.MonitorPackage.Schedule.MonitorScheduler;
import sweng.MonitorPackage.Schedule.ScheduleTask;
import sweng.MonitorPackage.Service.MonitorDataService;
import sweng.MonitorPackage.entry.MonitorEntry;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1210:41
 */
public class DefaultMonitorManager implements MonitorManager,MonitorDataDispatch{

    private List<MonitorDataService> monitorDataServices;
    private List<MonitorEntry> entries;
    private MonitorScheduler monitorScheduler;
    private MonitorAgentFactory monitorAgentFactory;
    private Logger log = Logger.getLogger(DefaultMonitorManager.class);

    public void setEntries(List<MonitorEntry> entries) {
        this.entries = entries;
    }

    public void setMonitorScheduler(MonitorScheduler monitorScheduler) {
        this.monitorScheduler = monitorScheduler;
    }

    public void setMonitorAgentFactory(MonitorAgentFactory monitorAgentFactory) {
        this.monitorAgentFactory = monitorAgentFactory;
    }

    public void setMonitorDataServices(List<MonitorDataService> monitorDataServices) {
        this.monitorDataServices = monitorDataServices;
    }

    @Override
    public void start() {
        if(monitorScheduler == null){
            monitorScheduler = new DefaultMonitorScheduler();
        }
        monitorScheduler.start();
        if(monitorAgentFactory == null){
            monitorAgentFactory = new DefaultMonitorFactory();
        }
        if(entries != null){
            for(MonitorEntry entry : entries){
                MonitorAgent agent = monitorAgentFactory.createAgent(entry);
                if(agent!=null) {
                    agent.setDataDispatcher(this);
                    if(agent instanceof ScheduleTask){
                        monitorScheduler.scheduler((ScheduleTask)agent);
                    }
                }
            }
        }

    }

    public MonitorDataService findMonitorDataService(String monitorService) {
        if(monitorService==null || monitorDataServices==null || monitorDataServices.size()==0){
            return null;
        }
        for (MonitorDataService service : monitorDataServices) {
            if(service.getConfig().equals(monitorService)){
                return service;
            }
        }
        return null;
    }

    @Override
    public void stop() {
        log.info("stop MonitorManager");
        if(monitorScheduler!=null){
            monitorScheduler.stop();
        }

        if(monitorDataServices!=null && monitorDataServices.size()>0){
            for (MonitorDataService each : monitorDataServices){
                each.destory();
            }
        }
    }

    @Override
    public void dispatch(MonitorEntry entry, MonitorData... data) {
        String service = entry.getService();
        MonitorDataService monitorDataService=null;
        if(service == null || service.length()==0){
            return;
        }
        String[] services = service.split(",");
        for(String each : services){
            monitorDataService = findMonitorDataService(each);
            if(monitorDataService!=null){
                monitorDataService.process(data);
            }else {
                log.info("Cannot find data service" + service + " to dispath.");
            }
        }

    }
}
