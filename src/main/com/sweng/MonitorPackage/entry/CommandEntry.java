package sweng.MonitorPackage.entry;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1019:23
 */
public class CommandEntry extends MonitorEntry {

    private String command;
    private long timeOut;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }
}
