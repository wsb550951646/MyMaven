package sweng.MonitorPackage.Sender;

import sweng.MonitorPackage.Data.MonitorData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1214:38
 */
public class SystemConsoleSender implements MonitorDataSender{

    private ExecutorService executors;

    @Override
    public void init(String config) {
        System.out.println("init config:"+config);
        executors= Executors.newCachedThreadPool();
    }

    @Override
    public void send(final MonitorData... data) {
        executors.execute(new Runnable() {
            @Override
            public void run() {
                for(MonitorData each : data){
                    System.out.println("code:"+each.getCode());
                    System.out.println("data:"+each.getData());
                    System.out.println("host:"+each.getHost());
                    System.out.println("TimeStamp:"+each.getTimestamp());
                    System.out.println("index:"+each.getIndex());
                }
            }
        });
    }

    @Override
    public void destroy() {
        executors.shutdown();
        System.out.println("SystemConsoleSender destory");
    }
}
