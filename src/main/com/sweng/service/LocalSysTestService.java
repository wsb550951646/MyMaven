package sweng.service;

import sweng.bean.SysTest;
import sweng.bean.SysTestResult;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/3013:43
 */
public interface LocalSysTestService {
    static final String CMD_LTASK = "LTASK"; // id name state source-state pid

    static final long timeout = 300000L;

    SysTestResult test(SysTest test) throws Exception;

    List<String> runShell(String cmd, long timeout) throws IOException, TimeoutException, InterruptedException;
}
