package sweng.MonitorPackage.Agent;

import sweng.MonitorPackage.Schedule.ScheduleTask;
import sweng.MonitorPackage.entry.CommandEntry;
import sweng.MonitorPackage.entry.MonitorEntry;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1020:20
 */
public abstract class AbstractCommandMonitorAgent extends AbstractMonitorAgent implements ScheduleTask {

    public AbstractCommandMonitorAgent(CommandEntry commandEntry) {
        super(commandEntry);
    }

    public CommandEntry getCommandEntry(){
        return (CommandEntry)getEntry();
    }

    @Override
    public long getInterval() {
        return getEntry().getInterval();
    }
}
