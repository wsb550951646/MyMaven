package sweng.mongodbaccess;

import com.mongodb.*;
import sweng.utils.*;
import org.apache.log4j.Logger;
import sweng.utils.condition.*;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/614:03
 */
public abstract class MongoDbOperationSupport {


    private static Logger logger = Logger.getLogger(MongoDbOperationSupport.class);
    protected DBObject createDoc(){

        BasicDBObject basicDBObject = new BasicDBObject();
        return basicDBObject;
    }

    protected DBObject createDoc(String key,Object value){

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put(key, value);
        return basicDBObject;
    }

    protected DBObject put(DBObject doc,String key,Object value){
        doc.put(key, value);
        return doc;
    }

    //T 是bean类 S是mongo数据库的类  将S类转化为T类的
    protected <T,S> List<T> fetch(Iterator<S> cursor, TypeConverter<T,S> tsTypeConverter){

        LinkedList<T> list = new LinkedList<>();
        while (cursor.hasNext()){
            T t = tsTypeConverter.converFrom(cursor.next());
            list.add(t);
        }
        return list;
    }

    private void buidFilter(DBObject filter, Condition condition){
        if(condition!=null)
            fillFilter(filter, condition);
    }


    private void fillOrFilter(BasicDBList orFilters, Condition condition){

        //or 创建不同的filter，每个不同的filter通过OR连接即可以实现OR
        DBObject filter = createDoc();
        fillFilter(filter, condition);
        orFilters.add(filter);

    }

    private void fillFilter(DBObject filter, Condition condition){
        //simpleCondition
        if(condition instanceof SimpleCondition){
            SimpleCondition simpleCondition = (SimpleCondition)condition;
            String name = simpleCondition.getName();
            Object value = simpleCondition.getValue();
            int op = simpleCondition.getOp();
            switch (op){
                case Condition.OP_EQ: {
                    put(filter, name, value);
                    break;
                }
                case Condition.OP_LIKE: {
                    DBObject innerfilter = createDoc();
                    value = ((String) value).replaceAll("%", ".*");
                    put(innerfilter, BuiltinKeys.REGEX, value);
                    put(innerfilter, BuiltinKeys.OPTIONS, "i");
                    break;
                }
                case Condition.OP_GT:
                case Condition.OP_LT:
                case Condition.OP_GE:
                case Condition.OP_LE:
                case Condition.OP_NE: {
                    DBObject inner = createDoc();
                    put(inner, getBuiltinKey(op), value);
                    put(filter, name, inner);
                    break;
                }
            }
        }
        //BetweenCondition
        else if(condition instanceof BetweenCondition){
            BetweenCondition betweenCondition = (BetweenCondition)condition;
            String name = betweenCondition.getName();
            Object value1 = betweenCondition.getValue1();
            Object value2 = betweenCondition.getValue2();

            DBObject inner = createDoc();
            if(value1 instanceof Date && value2 instanceof Date){
                put(inner, BuiltinKeys.GTE,((Date) value1).getTime());
                put(inner, BuiltinKeys.LTE,((Date) value2).getTime());
                put(filter, name, inner);
            }else {
                put(inner, BuiltinKeys.GTE, value1);
                put(inner, BuiltinKeys.LTE, value2);
                put(filter, name, inner);
            }
            return;
            //InCondition
        } else if(condition instanceof InCondition){
            InCondition inCondition = (InCondition)condition;
            String name = inCondition.getName();
            List<?> list = inCondition.getList();
            int op = inCondition.getOp();
            DBObject inner = createDoc();
            put(inner, getBuiltinKey(op),list);
            put(filter,name,inner);
            return;
            //LogicCondition
        }else if(condition instanceof LogicCondition){
            LogicCondition logicCondition = (LogicCondition)condition;
            List<Condition> logics = logicCondition.getLogics();
            int op = logicCondition.getOp();

            if(op == Condition.OP_AND){
                for(Condition cond : logics){
                    fillFilter(filter,cond);
                }
            }else if(op == Condition.OP_OR){
                BasicDBList filtervalues = new BasicDBList();
                for(Condition cond : logics){
                    fillOrFilter(filtervalues,cond);
                }
                if(filtervalues.size()>0){
                    put(filter, BuiltinKeys.OR, filtervalues);
                }
            }
            return;
        }

        return;
    }


    protected <T> Pager get(DBObject filter, DBObject sort, DBCollection collection, int pageIndex, int pageSize, TypeConverter<T,DBObject> typeConverter){

        long t1 = System.currentTimeMillis();
        DBCursor dbObjects = collection.find(filter);
        long t2 = System.currentTimeMillis();
        logger.debug("find:"+filter+ "db spend time:"+(t2-t1));
        t1 = t2;

        int count = dbObjects.count();

        DBCursor cursor = dbObjects.sort(sort).skip((pageIndex - 1) * pageSize).limit(pageSize);
        t2 = System.currentTimeMillis();
        logger.debug("sort and page spend time "+(t2 - t1));
        List<T> list = fetch(cursor, typeConverter);

        Pager pager = new Pager(pageIndex, pageSize, count, list);
        return pager;
    }

    protected DBObject createSort(List<SortOrder> list){

        //isAsc 属性是正序
        DBObject sort = createDoc();
        for(SortOrder sortOrder : list){
            sort.put(sortOrder.getName(), sortOrder.isAsc()? 1 : -1 );
        }

        return sort;
    }

    public String  getBuiltinKey(Integer op){

        switch (op){
            case Condition.OP_LT:
                return BuiltinKeys.LT;
            case Condition.OP_LE:
                return BuiltinKeys.LTE;
            case Condition.OP_GT:
                return BuiltinKeys.GT;
            case Condition.OP_GE:
                return BuiltinKeys.GTE;
            case Condition.OP_NE:
                return BuiltinKeys.NE;
            case Condition.OP_IN:
                return BuiltinKeys.IN;
            case Condition.OP_NOT_IN:
                return BuiltinKeys.NIN;
        }
        return null;
    }




}
