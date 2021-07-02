package sweng.MonitorPackage.Excutor;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1020:43
 */
public class DefaultCommandExecutor extends CommandExecutor<String> {

    @Override
    protected String parse(List<String> result) {
        if(result==null || result.size()==0)
            return null;

        return result.get(0);
    }
}
