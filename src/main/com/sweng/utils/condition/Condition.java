package sweng.utils.condition;

import sweng.utils.condition.BetweenCondition;
import sweng.utils.condition.InCondition;
import sweng.utils.condition.NoValueCondition;
import sweng.utils.condition.SimpleCondition;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/618:54
 */
public abstract class Condition {

    public static final int OP_AND = 0;
    public static final int OP_OR = 1;
    public static final int OP_EQ = 2;
    public static final int OP_NE = 3;
    public static final int OP_GT = 4;
    public static final int OP_GE = 5;
    public static final int OP_LT = 6;
    public static final int OP_LE = 7;
    public static final int OP_LIKE = 8;
    public static final int OP_NOT_LIKE = 9;
    public static final int OP_BETWEEN = 10;
    public static final int OP_NOT_BETWEEN = 11;
    public static final int OP_IN = 12;
    public static final int OP_NOT_IN = 13;
    public static final int OP_IS_NULL = 14;
    public static final int OP_IS_NOT_NULL = 15;
    public static final int OP_IS_EMPTY = 16;
    public static final int OP_IS_NOT_EMPTY = 17;
    protected int op;

    protected Condition(int op) {
        this.op = op;
    }

    public int getOp() {
        return this.op;
    }

    public static Condition eq(String name, Object value) {
        return new SimpleCondition(name, 2, value);
    }

    public static Condition ne(String name, Object value) {
        return new SimpleCondition(name, 3, value);
    }

    public static Condition gt(String name, Object value) {
        return new SimpleCondition(name, 4, value);
    }

    public static Condition ge(String name, Object value) {
        return new SimpleCondition(name, 5, value);
    }

    public static Condition lt(String name, Object value) {
        return new SimpleCondition(name, 6, value);
    }

    public static Condition le(String name, Object value) {
        return new SimpleCondition(name, 7, value);
    }

    public static Condition like(String name, Object value) {
        return new SimpleCondition(name, 8, value);
    }

    public static Condition notLike(String name, Object value) {
        return new SimpleCondition(name, 9, value);
    }

    public static Condition between(String name, Object value1, Object value2) {
        return new BetweenCondition(name, value1, value2, false);
    }

    public static Condition notBetween(String name, Object value1, Object value2) {
        return new BetweenCondition(name, value1, value2, true);
    }

    public static Condition in(String name, List<?> valueList) {
        return new InCondition(name, valueList, false);
    }

    public static Condition in(String name, Object... values) {
        return new InCondition(name, Arrays.asList(values), false);
    }

    public static Condition notIn(String name, List<?> valueList) {
        return new InCondition(name, valueList, true);
    }

    public static Condition notIn(String name, Object... values) {
        return new InCondition(name, Arrays.asList(values), true);
    }

    public static Condition isNull(String name) {
        return new NoValueCondition(name, 14);
    }

    public static Condition isNotNull(String name) {
        return new NoValueCondition(name, 15);
    }

    public static Condition isEmpty(String name) {
        return new NoValueCondition(name, 16);
    }

    public static Condition isNotEmpty(String name) {
        return new NoValueCondition(name, 17);
    }





}
