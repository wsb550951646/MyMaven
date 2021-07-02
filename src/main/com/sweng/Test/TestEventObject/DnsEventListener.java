package sweng.Test.TestEventObject;

import java.util.EventListener;

/**
 * @Description:
 *
 *  事件监听器的接口，对DnsEvent事件进行监听，参数DnsEvent ，对该参数进行具体操作
 *
 * @Author: swengcode
 * @Date: 2020/8/3015:34
 */
public interface DnsEventListener extends EventListener {

    void ProcessDnsEvent(DnsEvent dnsEvent);

}
