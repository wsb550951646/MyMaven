package sweng.utils.condition;

import sweng.utils.condition.Condition;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/618:58
 */
public class FieldCondition extends Condition {
    private String name;

    protected FieldCondition(String name,int op) {
        super(op);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
