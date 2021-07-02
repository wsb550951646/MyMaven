package sweng.utils.condition;

import sweng.utils.condition.FieldCondition;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/619:00
 */
public class SimpleCondition extends FieldCondition {
    private Object value;

    protected SimpleCondition(String name, int op,Object value) {
        super(name, op);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
