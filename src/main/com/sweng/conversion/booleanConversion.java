package sweng.conversion;

import com.sun.javafx.css.converters.BooleanConverter;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/2619:39
 */
public class booleanConversion extends StrutsTypeConverter {

    private Logger logger = Logger.getLogger(BooleanConverter.class);
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {

        logger.info("[info]:use booleaConversion");

        String booleanstr  = strings[0];
        Boolean booleanVal = Boolean.TRUE;

        if(booleanstr == null || booleanstr.length()==0 || booleanstr.equals("true") ||
        booleanstr.equals("0") || booleanstr.equals("no") || booleanstr.equals("false")){
            booleanVal =  Boolean.FALSE;
        }

        return booleanVal;
    }

    @Override
    public String convertToString(Map map, Object o) {
        return null;
    }
}
