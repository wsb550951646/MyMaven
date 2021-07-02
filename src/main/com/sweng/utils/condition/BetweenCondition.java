package sweng.utils.condition;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/618:58
 */
public class BetweenCondition extends FieldCondition {
    private Object value1;
    private Object value2;

    protected BetweenCondition(String name,Object value1,Object value2,boolean reverse) {
        super(name, reverse?10:11);
        this.value1 = value1;
        this.value2 = value2;
    }

    public Object getValue1() {
        return value1;
    }

    public Object getValue2() {
        return value2;
    }
}
