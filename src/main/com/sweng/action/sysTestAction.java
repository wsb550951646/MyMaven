package sweng.action;

import sweng.bean.SysTest;
import sweng.bean.SysTestResult;
import sweng.service.SysTestService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/2615:00
 */
public class sysTestAction extends BaseServerSettingAction {
    private SysTestService sysTestService;
    private List<SysTest> tests;
    private Long sessionId;
    private Integer testId;
    private Integer clientTime; // unix timestamp, seconds
    private Boolean result;
    private String info;

    private Long lastSessionId = -1L;
    private List<SysTestResult> results = new ArrayList<SysTestResult>();

    public sysTestAction() {
    }

    /**
     * for json output, the result code
     */
    private int code;
    /**
     * for json output, the detail fail description.
     */
    private String description;

    public sysTestAction(SysTestService sysTestService) {
        this.sysTestService = sysTestService;
    }

    public SysTestService getSysTestService() {
        return sysTestService;
    }

    public void setSysTestService(SysTestService sysTestService) {
        this.sysTestService = sysTestService;
    }

    public List<SysTest> getTests() {
        return tests;
    }

    public void setTests(List<SysTest> tests) {
        this.tests = tests;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getClientTime() {
        return clientTime;
    }

    public void setClientTime(Integer clientTime) {
        this.clientTime = clientTime;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getLastSessionId() {
        return lastSessionId;
    }

    public void setLastSessionId(Long lastSessionId) {
        this.lastSessionId = lastSessionId;
    }

    public List<SysTestResult> getResults() {
        return results;
    }

    public void setResults(List<SysTestResult> results) {
        this.results = results;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String list() {

        tests = sysTestService.getTests();

        return SUCCESS;
    }

    public String test() throws Exception {

        if(lastSessionId!=sessionId)
        {
            results.clear();
            lastSessionId = sessionId;
        }

        SysTestResult sysTestResult = new SysTestResult();
        sysTestResult = sysTestService.test(null, testId, clientTime.toString());
        this.result = sysTestResult.getResult();
        this.info = sysTestResult.getInfo();

        results.add(sysTestResult);

        return SUCCESS;
    }

}
