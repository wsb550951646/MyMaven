package sweng.MonitorPackage.Agent;

import sweng.MonitorPackage.entry.CommandEntry;
import sweng.MonitorPackage.entry.MonitorEntry;
import sweng.MonitorPackage.entry.PeriodCommandEntry;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1110:27
 */
public class DefaultMonitorFactory implements MonitorAgentFactory {
    @Override
    public MonitorAgent createAgent(MonitorEntry entry) {
        MonitorAgent agent = null;
        if(entry instanceof CommandEntry) {
            agent = new DefaultCommandMonitorAgent((CommandEntry) entry);
        }else if(entry instanceof PeriodCommandEntry){
            agent = new DefaultPeriodCommandMonitorAgent((PeriodCommandEntry) entry);
        }
        return agent;
    }
}
