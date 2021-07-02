package sweng.MonitorPackage.Schedule;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1117:50
 */
public interface MonitorScheduler {

    void start();

    void stop();

    void scheduler(ScheduleTask task);

}
