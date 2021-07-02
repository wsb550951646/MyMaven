package sweng.MonitorPackage.Agent;

import sweng.MonitorPackage.entry.MonitorEntry;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1110:24
 */
public interface MonitorAgentFactory {

    MonitorAgent createAgent(MonitorEntry entry);

}
