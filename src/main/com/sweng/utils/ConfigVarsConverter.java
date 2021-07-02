package sweng.utils;

import java.util.Properties;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/910:28
 */
//支持使用${}，从System中去出已存放的值

public class ConfigVarsConverter {

    private static final String DELIM_START = "${";
    private static final char DELIM_STOP = '}';
    private static final int DELIM_START_LEN = 2;
    private static final int DELIM_STOP_LEN = 1;

    private ConfigVarsConverter(){

    }

    public static String getProperty(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null)
            return null;
        try {
            return replaceVars(value, props);
        } catch (IllegalArgumentException e) {
            return value;
        }
    }


    /*
        改工具类是将 传入的带${}的str 通过在System中去取值，解析为str字符串。

        关键点还是要抓住 3个位置点 和 递归出口。使用buff不停的添加

        递归出口1：返回${key} 里面的value值，添加进buffstr
        递归出口2：i的游标，且后无${ ，且buff添加val.[i,val.length)，返回结果

        I位置点：val的游标值，寻找${的实际位置
        J位置点：第一次发现${的位置游标
        K位置点：第一次发现}的位置游标

     */
    public static String replaceVars(String val,Properties props)throws IllegalArgumentException {
        StringBuffer buffstr = new StringBuffer();
        int i = 0;
        int j,k;

        //while无限循环，唯一的出口就是1里面的值val值
        while (true){

            //1.普通的val值，找不到${ （j==-1）
             j = val.indexOf(DELIM_START, i);
            if(j == -1){
                //1.1 是${}里面的值直接返回，未移动过 （i==0）
                if(i == 0)
                 return val;
                //1.2 非${}值，i移动过，将i到val.length 长度添加进buff(已经没有${})
                else{
                    buffstr.append(val.substring(i,val.length()));
                    return buffstr.toString();
                }
             }
            //2.val值中含有${的参数
            else{
                //2.1 先将无${} 保存
                buffstr.append(val.substring(i,j));
                //2.2 获取}的位置，把${}里面的值去出来 (用k保存第一个出现}值 )
                k = val.indexOf(DELIM_STOP, j);
                if(k == -1) {
                    throw new IllegalArgumentException('"' + val
                            + "\" has no closing brace. Opening brace at position " + j + '.');
                }
                //2.2 从System里去取，没有就从props中取
                else {
                    j += DELIM_START_LEN;
                    String key = val.substring(j, k);
                    String replacement = System.getProperty(key);
                    if(replacement == null && props != null){
                         replacement = props.getProperty(key);
                    }
                    //2.3 再次调用replaceVar，查看是否还有${
                    if(replacement != null){
                        String recursiveReplacement = replaceVars(replacement, props);
                        //2.4 返回的值添加到String的buff中
                        buffstr.append(recursiveReplacement);
                    }
                    //2.5 继续查看val后面的数值
                    i = k+DELIM_STOP_LEN;
                }
            }
        }
    }
}
