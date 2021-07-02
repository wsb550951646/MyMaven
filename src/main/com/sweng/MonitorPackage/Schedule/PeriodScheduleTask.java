package sweng.MonitorPackage.Schedule;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1020:17
 */
public interface PeriodScheduleTask extends ScheduleTask {

    void periodExecute();

    long getPeriodInterval();

}
