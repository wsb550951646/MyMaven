package sweng.MonitorPackage.Agent;

import sweng.MonitorPackage.Excutor.DefaultCommandExecutor;
import sweng.MonitorPackage.Excutor.DefaultGroupCommandExecutor;
import sweng.MonitorPackage.Schedule.PeriodScheduleTask;
import sweng.MonitorPackage.Utils.NumberUtils;
import sweng.MonitorPackage.entry.PeriodCommandEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1110:32
 */
public class DefaultPeriodCommandMonitorAgent extends AbstractCommandMonitorAgent implements PeriodScheduleTask {

    HashMap<String, List<Number>> resultmap = new HashMap<>();
    Object lock = new Object();

    public DefaultPeriodCommandMonitorAgent(PeriodCommandEntry entry) {
        super(entry);
    }

    @Override
    public void execute() {
        synchronized (lock) {
            for (Map.Entry<String, List<Number>> each : resultmap.entrySet()) {
                Number average = NumberUtils.average(each.getValue());
                if(average!=null){
                    String key = each.getKey();
                    if(key!=null && !key.isEmpty()){
                        dispatche(key, average);
                    }else {
                        dispatche(average);
                    }
                }
            }
        }
    }

    @Override
    public void periodExecute() {
        if(getCommandEntry().isGroup()){
            DefaultGroupCommandExecutor executor = new DefaultGroupCommandExecutor();
            executor.setCommandEntry(getCommandEntry());
            Map<String, String> results = executor.execute();
            if(results!=null){
                synchronized (lock) {
                    for (Map.Entry<String, String> entry : results.entrySet()) {
                        String key = entry.getKey();
                        Number number = NumberUtils.parseNumber(entry.getValue());
                        add(key, number);
                    }
                }
            }
        }else {
            DefaultCommandExecutor executor = new DefaultCommandExecutor();
            executor.setCommandEntry(getCommandEntry());
            String result = executor.execute();
            if(result!=null){
                Number number = NumberUtils.parseNumber(result);
                if(number!=null) {
                    synchronized (lock){
                    add("", number);
                    }
                }
            }
        }
    }

    public void add(String key,Number number){
        List<Number> numbers = resultmap.get(key);
        if(number==null){
            numbers = new ArrayList<>();
            resultmap.put(key, numbers);
        }
        numbers.add(number);
    }

    @Override
    public long getPeriodInterval() { return ((PeriodCommandEntry)getEntry()).getPeriodInterval(); }


}
