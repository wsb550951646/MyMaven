package sweng.MonitorPackage.Excutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1020:45
 */
public class DefaultGroupCommandExecutor extends CommandExecutor<Map<String,String>> {
    @Override
    protected Map<String, String> parse(List<String> result) {
        if(result==null || result.size() == 0)
            return null;
        HashMap<String, String> resultHashMap = new HashMap<>();
        for(String each : result){
            String[] arr = each.split("\\s+", 2);
            if(arr!=null && arr.length>1){
                resultHashMap.put(arr[0],arr[1]);
            }
        }
        return resultHashMap;
    }
}
