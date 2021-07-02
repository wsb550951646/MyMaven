package sweng.utils.condition;

import sweng.utils.condition.FieldCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/619:04
 */
public class InCondition extends FieldCondition {
    private List<?> list = new ArrayList<>();


    protected InCondition(String name, List<?> list,boolean reverse) {
        super(name, reverse?12:13);
        this.list = list;
    }

    public List<?> getList() {
        return list;
    }
}
