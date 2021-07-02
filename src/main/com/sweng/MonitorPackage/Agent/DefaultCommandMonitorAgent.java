package sweng.MonitorPackage.Agent;

import sweng.MonitorPackage.Excutor.DefaultCommandExecutor;
import sweng.MonitorPackage.Excutor.DefaultGroupCommandExecutor;
import sweng.MonitorPackage.entry.CommandEntry;
import java.util.Map;
/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1020:26
 */
public class DefaultCommandMonitorAgent extends AbstractCommandMonitorAgent {

    public DefaultCommandMonitorAgent(CommandEntry commandEntry) {
        super(commandEntry);
    }
    @Override
    public void execute() {
        if(getCommandEntry().isGroup()){
            DefaultGroupCommandExecutor executor = new DefaultGroupCommandExecutor();
            executor.setCommandEntry(getCommandEntry());
            Map<String, ?> result = executor.execute();
            if(result!=null){
                for(Map.Entry<String,?> each:result.entrySet()){
                    dispatche(each.getKey(), each.getValue());
                }
            }
        }else {
            DefaultCommandExecutor executor = new DefaultCommandExecutor();
            executor.setCommandEntry(getCommandEntry());
            String result = executor.execute();
            if(result!=null){
              dispatche(result);
            }
        }
    }
}
