package sweng.MonitorPackage.Service;

import org.apache.log4j.Logger;
import sweng.MonitorPackage.Data.MonitorData;
import sweng.MonitorPackage.Manager.DefaultMonitorManager;
import sweng.MonitorPackage.Sender.MonitorDataSender;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1214:21
 */
public class DefaultMonitorDataService implements MonitorDataService {

    private String config;
    private ExecutorService executor;
    private List<MonitorDataSender> senders;
    private Logger log = Logger.getLogger(DefaultMonitorManager.class);

    @Override
    public void init(String configName) {
        log.info("init configName:"+configName);
        executor = Executors.newCachedThreadPool();
    }

    @Override
    public String getConfig() {
        return config;
    }

    @Override
    public void process(final MonitorData... data) {

        if(senders!=null || senders.size()>0) {
            for (final MonitorDataSender sender : senders) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        sender.send(data);
                    }
                });

            }
        }
    }

    @Override
    public void destory() {
        log.info("destory data service:"+config);
        if(executor!=null){
            executor.shutdownNow();
        }
        if(senders!=null){
            for(MonitorDataSender sender : senders){
                sender.destroy();
            }
        }

    }
}
