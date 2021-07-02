package sweng.MonitorPackage.Schedule;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1020:15
 */
public interface ScheduleTask {

    long getInterval();

    void execute();

}
