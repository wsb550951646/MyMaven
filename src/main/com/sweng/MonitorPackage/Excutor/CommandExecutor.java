package sweng.MonitorPackage.Excutor;

import com.arcsoft.arcvideo.common.utils.CommandUtils;
import sweng.MonitorPackage.entry.CommandEntry;
import sweng.MonitorPackage.entry.MonitorEntry;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1020:33
 */
public abstract class CommandExecutor<T> implements MonitorExecutor<T>{


    private CommandEntry commandEntry;

    public CommandEntry getCommandEntry() {
        return commandEntry;
    }

    public void setCommandEntry(CommandEntry commandEntry) {
        this.commandEntry = commandEntry;
    }

    @Override
    public T execute() {
        try {
            List<String> list = CommandUtils.executeShell(commandEntry.getCommand(), commandEntry.getTimeOut());
            if(list !=null){
                //不同的解析方式
                return parse(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected  abstract T parse(List<String> result);
}
