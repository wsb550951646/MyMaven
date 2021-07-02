package sweng.Test.TestEventObject;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/8/3015:36
 */
public class DnsEventListenImp implements DnsEventListener {


    @Override
    public void ProcessDnsEvent(DnsEvent dnsEvent) {
        System.out.println("--对DnsEvent事件继续监听--");
        System.out.println("该事件的参数值userData:"+dnsEvent.getUserData()+" Time"+dnsEvent.getTime());
    }
}
