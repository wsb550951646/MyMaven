package sweng.MonitorPackage.Utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1111:07
 */
public class NumberUtils {

    private static final Pattern NUMBER = Pattern.compile("^[+-]?([0]|(0[xX#][0-9a-fA-F]+[lL]?)|([1-9][0-9]*[lL]?)|([0][0-7]+[lL]?)|([0-9]+([.][0-9]+)?[dDfF]?))$");

    private NumberUtils() {
    }

    /**
     * Test the string value is a number string or not
     *
     * @param value - the string to test
     * @return true if it is a number string.
     */
    public static boolean isNumber(String value) {
        Matcher m = NUMBER.matcher(value);
        return m.matches();
    }

    /**
     * Parse string to number.
     *
     * @param value - the number string
     * @return a Number object holding the value represented by value.
     */
    public static Number parseNumber(String value) {
        if (value == null) {
            return null;
        }
        if (!isNumber(value)) {
            return null;
        }
        if (value.contains(".")) {
            return Float.valueOf(value);
        } else if (value.length() > 1){
            char c = value.charAt(value.length() - 1);
            switch (c) {
                case 'l':
                case 'L':
                    return Long.decode(value);
                case 'f':
                case 'F':
                    return Float.valueOf(value);
                case 'd':
                case 'D':
                    return Double.valueOf(value);
                default:
                    break;
            }
        }
        return Integer.decode(value);
    }

    /**
     * Calculate the average value of the specified values.
     *
     * @param values - the values to calculate
     * @return the average value.
     */
    public static Number average(List<Number> values) {
        AverageCalculator<Number> average = AverageCalculator.getAverageCalculator(values.get(0).getClass());
        if (average != null) {
            return average.average(values);
        }
        return null;
    }


}
