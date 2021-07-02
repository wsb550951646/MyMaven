package sweng.MonitorPackage.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1111:17
 */
public abstract class AverageCalculator<T> {

    public static Map<Class<?>,AverageCalculator<?>> calculators = new HashMap<>();

    static {
        calculators.put(Integer.class, new IntegerAverageCalculator());
        calculators.put(Byte.class, new ByteAverageCalculator());
        calculators.put(Short.class, new ShortAverageCalculator());
        calculators.put(Long.class,new LongAverageCalculator());
        calculators.put(Float.class,new FloatAverageCalculator() );
        calculators.put(Double.class, new DoubleAverageCalculator());
    }

    public abstract T average(List<T> valuelist);

    public static <E> AverageCalculator<E> getAverageCalculator(Class<?> clazz){
        return (AverageCalculator<E>) calculators.get(clazz);
    }

    public static Long averageNumber(List<? extends Number> values){
        long total = 0;
        for(Number number : values){
            total += number.longValue();
        }
        return total/values.size();
    }

    private static Double averageDouble(List<? extends Number> values) {
        double total = 0;
        for (Number t : values) {
            total += t.doubleValue();
        }
        return total / values.size();
    }


    private static class IntegerAverageCalculator extends AverageCalculator<Integer>{
        @Override
        public Integer average(List<Integer> valuelist) {
            return averageNumber(valuelist).intValue();
        }
    }

    private static class ByteAverageCalculator extends AverageCalculator<Byte> {

        @Override
        public Byte average(List<Byte> values) {
            return averageNumber(values).byteValue();
        }
    }

    private static class ShortAverageCalculator extends AverageCalculator<Short> {

        @Override
        public Short average(List<Short> values) {
            return averageNumber(values).shortValue();
        }
    }

    private static class LongAverageCalculator extends AverageCalculator<Long> {

        @Override
        public Long average(List<Long> values) {
            return averageNumber(values);
        }
    }

    private static class FloatAverageCalculator extends AverageCalculator<Float> {

        @Override
        public Float average(List<Float> values) {
            return averageDouble(values).floatValue();
        }
    }

    private static class DoubleAverageCalculator extends AverageCalculator<Double> {

        @Override
        public Double average(List<Double> values) {
            return averageDouble(values);
        }
    }


}
