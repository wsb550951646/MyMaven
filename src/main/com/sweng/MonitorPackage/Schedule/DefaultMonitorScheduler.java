package sweng.MonitorPackage.Schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1117:51
 */
public class DefaultMonitorScheduler implements MonitorScheduler {

    private int DEFAULT_SCHEDULE = 10;
    private ScheduledExecutorService schedule;

    @Override
    public void start() {
        schedule = Executors.newScheduledThreadPool(DEFAULT_SCHEDULE);
    }

    @Override
    public void stop() {
        if(schedule!=null){
            schedule.shutdown();
        }
    }

    @Override
    public void scheduler(final ScheduleTask task) {

        if(task instanceof PeriodScheduleTask){
            final PeriodScheduleTask periodTask = (PeriodScheduleTask)task;
            schedule.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    try {
                        periodTask.periodExecute();
                    }catch (Exception e){

                    }
                }
            }, 0, periodTask.getPeriodInterval(), TimeUnit.SECONDS);

        }

        schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                task.execute();
            }
        }, task.getInterval(), task.getInterval(), TimeUnit.SECONDS);


    }
}
