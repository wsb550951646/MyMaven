package sweng.Test.TestFileUtils;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/1917:35
 */
public class TestFileUtils {


    static class FileNameFilter{
        public static FilenameFilter filter(final String regx){
            return new FilenameFilter(){
                private Pattern pattern = Pattern.compile(regx+"_*");
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            };
        }
    }

    @Test
    public void test1(){

        Pattern pattern = Pattern.compile("a+");
        pattern.pattern();
//        System.out.println("-"+pattern.pattern()
        System.out.println("-"+Pattern.matches(pattern.pattern(), "aaaa"));     //true
        System.out.println("-"+Pattern.matches(pattern.pattern(), "a+"));       //false
        System.out.println("-"+Pattern.matches("a\\+", "a+"));            //true
        System.out.println("-"+Pattern.matches("a\\+", "aaa"));           //false
        System.out.println("-"+Pattern.matches("a\\\\+", "aaa"));         //false
        System.out.println("-"+Pattern.matches("a\\+", "aaa"));         //false


    }

    @Test
    public void testFileList(){
            Pattern pattern = Pattern.compile("aish_\\d+\\.ts");
            //pattern.matcher(name)
            String name = "aish_.*$";
            String name2 = "aish_1.ts";
            String filename = "E:\\TestFile\\aish_1.ts";
            File file = new File(filename);
            File parentFile = file.getParentFile();

            //System.out.println(file.getName());

             String[] list = parentFile.list(FileNameFilter.filter(name));
             for(String s : list){
                 System.out.println(s);
             }

        System.out.println(pattern.matcher(name2).matches());
        System.out.println(Pattern.matches(pattern.pattern(), name2));
        }





    @Test
    public void testwrite() throws IOException {

        //不存在自动创建
        String FilePath = "E:\\testFile\\a.txt";
        String context = "{\"name\":\"BeJson帅\",\"url\":\"http://www.bejson.com\"page\":88,\"isNonProfit\":true}";
        //FileUtils.write(new File(FilePath),context);

    }

    @Test
    public void testwrite2() throws IOException {

        //不存在自动创建,会添加
        String FilePath = "E:\\testFile2";
        File file = new File(FilePath);
        file.delete();


        String context = "{1123}";
        //FileUtils.write(new File(FilePath), context, true);
    }

    @Test
    public void testReadFileToString() throws IOException {
        String FilePath = "E:\\testFile\\a.txt";
        String s = FileUtils.readFileToString(new File(FilePath), "UTF-8");
        System.out.println(s);
        String FilePath2 = "E:\\testFile\\ad.txt";
        File file = new File(FilePath2);
    }

    @Test
    public void testFilter(){

        String FilePath = "E:\\testFile";
        File[] files = new File(FilePath).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.startsWith("a") || name.endsWith(".txt"))
                    return true;
                else
                    return false;
            }
        });

        List<File> filesList = Arrays.asList(files);
        compareFile(filesList);
        for(File file : filesList){

            System.out.println(file.getName());

        }

    }

    public void compareFile(List<File> files){

        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if(o1.getName().length() > o2.getName().length())
                    return 1;
                if(o1.getName().length() < o2.getName().length())
                    return -1;
                return o1.getName().compareTo(o2.getName());
            }
        });


    }



}
