package sweng.serviceImp.systest;

import sweng.Throwable.InvalidSysTestSettingException;
import sweng.bean.Server;
import sweng.bean.SysTest;
import sweng.bean.SysTestResult;
import sweng.service.LocalSysTestService;
import sweng.service.SysTestService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/3010:12
 */
public class SysTestServiceImp implements SysTestService {

    private List<SysTest> tests;

    private LocalSysTestService localSysTestService;

    public SysTestServiceImp() {
    }

    public void setLocalSysTestService(LocalSysTestServiceImp localSysTestService) {
        this.localSysTestService = localSysTestService;
    }


    public void init() throws JAXBException {

        System.out.println("------init-----");
        //URL url = getClass().getClassLoader().getResource("");
        InputStream in = getClass().getClassLoader().getResourceAsStream("systest.xml");
        if(in != null){
            JAXBContext jaxbContext = JAXBContext.newInstance(SysTestList.class);
            Unmarshaller marshaller = jaxbContext.createUnmarshaller();
            //SysTestList list = (SysTestList) marshaller.unmarshal(url);
            SysTestList list  =(SysTestList) marshaller.unmarshal(in);
            tests = list.getList();

            for(SysTest test:tests){
                verifyTestCondition(test);
            }


        }else{

            System.out.println("--- url 为空 ---");
        }

        System.out.println("init");
    }

    @Override
    public List<SysTest> getTests() {
        return tests;
    }

    @Override
    public SysTestResult test(Server server, int testId, String clientTime) throws Exception {
        SysTest test = getTest(testId);
        if(test==null)
            return null;

        if(server==null){

            System.out.println("find test - "+test);
            SysTestResult testResult = localSysTestService.test(test);
            return testResult;

        }else {
            System.out.println("remote other ip server");
        }

        return null;
    }

    public void verifyTestCondition(SysTest test){

        String condition = test.getCondition();
        String op  = "";
        String v = null;
        Float value;
        byte[] bytes = condition.trim().getBytes();

        for (int i = 0; i < condition.length(); i++) {

            if(bytes[i]!='>' && bytes[i]!='<' && bytes[i]!='=' && bytes[i]!='!'){
                v = condition.substring(i);
                break;
            }
            op+=(char)bytes[i];
        }

        if(!op.equals(SysTest.OP_EQ)   &&
            !op.equals(SysTest.OP_GT)  &&
            !op.equals(SysTest.OP_GTE) &&
            !op.equals(SysTest.OP_LT)  &&
            !op.equals(SysTest.OP_LTE) &&
            !op.equals(SysTest.OP_EQ)){
        throw new InvalidSysTestSettingException("condition is error");
        }

        if(v==null || v.isEmpty()){
            throw new InvalidSysTestSettingException("condition value is null");
        }

        try {
            value = Float.valueOf(v);
        } catch (Exception ex){
            throw new InvalidSysTestSettingException("Exception valueOf is error");
        }

        test.setConditionOp(op);
        test.setConditionValue(value);

    }

    public SysTest getTest(Integer testId){

        List<SysTest> tests = getTests();
        for (SysTest sysTest : tests){
            if(sysTest.getId().equals(testId)){
                return sysTest;
            }

        }
        return null;
    }



    @XmlRootElement(name = "systest")
    @XmlAccessorType(XmlAccessType.PROPERTY)
    private static class SysTestList{

        @XmlElementWrapper(name = "tests")
        @XmlElement(name = "test")
        private List<SysTest> list = new ArrayList<>();

        @XmlTransient
        public List<SysTest> getList(){
            return list;
        }

        public void setList(List<SysTest> list) {
            this.list = list;
        }
    }

}
