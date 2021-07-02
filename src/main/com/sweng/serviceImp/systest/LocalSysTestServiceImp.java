package sweng.serviceImp.systest;

import junit.framework.TestResult;
import org.apache.commons.io.FileUtils;
import sweng.bean.SysTest;
import sweng.bean.SysTestResult;
import sweng.service.LocalSysTestService;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/3013:43
 */
public class LocalSysTestServiceImp implements LocalSysTestService {
    @Override
    public SysTestResult test(SysTest test) throws Exception {

        System.out.println("localSysTest -- id: "+test.getId()+" command: " + test.getCommand());

        SysTestResult testResult = new SysTestResult();
        testResult.setId(test.getId());

        List<String> list = runShell(test.getCommand(), test.getTimeout() != null ? test.getTimeout() : timeout);

        for(String tag : list){
            if(tag!=null)
                testResult.setValue(tag);
                break;
        }
        if(test.getInfo()!=null && !test.getInfo().isEmpty()){
            String result = readTestInfo(test.getInfo(), false);
            System.out.println("处理结果："+result);
            testResult.setInfo(result);
        }

        // temp code
        testResult.setResult(true);

        return testResult;
    }

    @Override
    public List<String> runShell(String cmd, long timeout) throws IOException, TimeoutException, InterruptedException {

        List<String> result = Arrays.asList("0");
        String[] mockResult = {"coordinator is OK","mongogdb is OK","alert is OK"};
        File file = new File("systest.tmp");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for(String s : mockResult){
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        //demo
        return result;
    }

    public String readTestInfo(String fileName,boolean delete)  {

        if(fileName==null || fileName.isEmpty())
            return null;
        File file = new File(fileName);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line!=null){
            if(sb.length()>0)
                sb.append(System.lineSeparator());
            sb.append(line);
            line = bufferedReader.readLine();
        }
        return sb.toString();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //删除文件夹
            if(delete){
                if(file!=null && file.exists() ){
                    if(!file.delete()){
                        System.out.println("Delete file failed:"+fileName);
                    }
                }

            }

        }

        return null;
    }

}
