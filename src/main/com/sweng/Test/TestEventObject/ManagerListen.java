package sweng.Test.TestEventObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 *
 *  事件的发生源，包含有事件的监听器属性。
 *
 *  事件发生的地方，因为事件源的某项属性或状态发生了改变导致某项事件发生
 *
 * @Author: swengcode
 * @Date: 2020/8/3015:37
 */
public class ManagerListen {

    private List<DnsEventListener> listeners = null;


    private static class Singleton {
        static ManagerListen managerListener = new ManagerListen();
    }

    public static ManagerListen getInstance() {
        return Singleton.managerListener;
    }

    private ManagerListen() {
        listeners = new ArrayList<>();
    }

    public List<DnsEventListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<DnsEventListener> listeners) {
        this.listeners = listeners;
    }

    public void fireDnsEventListener(DnsEvent event){

        for(DnsEventListener dnsEventListener : listeners){
            dnsEventListener.ProcessDnsEvent(event);
        }

    }

    public void removeListener(DnsEventListener dnsEventListener){
        listeners.remove(dnsEventListener);
    }

    public void addListener(DnsEventListener dnsEventListener){
        listeners.add(dnsEventListener);
    }

    public static void main(String[] args) {

        Object o = new Object();
        ManagerListen managerListener = ManagerListen.getInstance();
        managerListener.addListener(new DnsEventListenImp());


        managerListener.addListener(new DnsEventListener() {
            @Override
            public void ProcessDnsEvent(DnsEvent dnsEvent) {
                System.out.println("新的监听器");
                System.out.println("dns"+dnsEvent.getTime()+" "+dnsEvent.getUserData());
            }
        });

        DnsEvent test = new DnsEvent(o, "test", 10);
        managerListener.fireDnsEventListener(test);


    }

}
