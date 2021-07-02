package sweng.mongodbaccess;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import sweng.utils.condition.BuiltinKeys;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/917:07
 *
 * name对应的其他collections 的名称
 *
 * nextid 是对应的是下一个id的数值
 *
 * 此表作用是生成其他表的nextid的数值信息，使用findAndModify是原子操作。
 *
 *
 */
public class DefultIdGenerator extends MongoDbOperationSupport implements IdGenerator<Integer> {

    private final static String COLLECTIONNAME = "nextids";
    private final String KEY_NAME = "name";
    private final String KEY_NEXTID = "nextid";

    private DBCollection collection;
    private String name;
    private MongoDBConnect dbConnect;

    public DefultIdGenerator() {
    }

    public DefultIdGenerator(String name,MongoDBConnect dbConnect) {
        this.name = name;
        this.dbConnect = dbConnect;
    }

    public DefultIdGenerator(DBCollection collection, String name) {
        this.collection = collection;
        this.name = name;
    }

    public DefultIdGenerator(DB db,String name){
        this(db.getCollection(COLLECTIONNAME),name);
    }

    private DBCollection getCollection(){

        if(dbConnect!=null)
            collection = dbConnect.getMongoDB().getCollection(COLLECTIONNAME);

        return collection;
    }


    @Override
    public Integer generateId() {

        final Integer detl = 1;

        DBObject query = createDoc();
        put(query, KEY_NAME, name);
        DBObject update = createDoc();
        put(update, BuiltinKeys.INC, detl);


        DBCollection collection = getCollection();
        DBObject found = collection.findAndModify(query, null, null, false, update, true, true);

        return (Integer)found.get(KEY_NEXTID);

    }



}
