package sweng.utils.condition;

import sweng.utils.condition.Condition;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/619:11
 */
public class LogicCondition extends Condition {
    private List<Condition> logics = new ArrayList<>();

    protected LogicCondition(int op) {
        super(op);
    }

    public void add(Condition condition){

        logics.add(condition);
    }

    public List<Condition> getLogics() {
        return logics;
    }
}
