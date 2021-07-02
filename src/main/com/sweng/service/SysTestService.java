package sweng.service;

import sweng.bean.Server;
import sweng.bean.SysTest;
import sweng.bean.SysTestResult;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/2717:36
 */
public interface SysTestService {

    List<SysTest> getTests();

    SysTestResult test(Server server, int testId, String clientTime) throws Exception;

}
