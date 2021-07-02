package sweng.utils.condition;

import sweng.utils.condition.FieldCondition;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/619:10
 */
public class NoValueCondition extends FieldCondition {
    protected NoValueCondition(String name, int op) {
        super(name, op);
    }
}
