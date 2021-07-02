package sweng.dao.user;

import sweng.bean.User;
import com.mongodb.*;
import sweng.mongodbaccess.MongoDBConnect;
import sweng.mongodbaccess.MongoDbOperationSupport;
import sweng.mongodbaccess.TypeConverter;
import sweng.mongodbaccess.IdGenerator;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/818:57
 */
public class DefaultUserDao extends MongoDbOperationSupport implements UserDao {
    private final static String COLLECTIONNAME = "users";

    private final TypeConverter<User,DBObject>userTypeConverter = new UserTypeConverter();
    private DBCollection userCollection;
    private IdGenerator<Integer> idGenerator;

    private MongoDBConnect dbConnect;

    public DefaultUserDao(MongoDBConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    public DefaultUserDao(DBCollection dbCollection){
        this.userCollection = dbCollection;
    }

    public DefaultUserDao(DB db){
        this(db.getCollection(COLLECTIONNAME));
    }

    public TypeConverter<User, DBObject> getUserTypeConverter() {
        return userTypeConverter;
    }

    public void setUserCollection(DBCollection userCollection) {
        this.userCollection = userCollection;
    }

    public IdGenerator<Integer> getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator<Integer> idGenerator) {
        this.idGenerator = idGenerator;
    }

    public MongoDBConnect getDbConnect() {
        return dbConnect;
    }

    public void setDbConnect(MongoDBConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    public DBCollection getUserCollection(){
        if(dbConnect!=null){
            DBCollection collection = dbConnect.getMongoDB().getCollection(COLLECTIONNAME);
            return collection;
        }
        return null;
    }

    public DBObject createquery(Integer id){
        return createDoc(UserSchemaKeys.USERID, id);
    }

    @Override
    public User get(Integer id) {
        DBObject query = createDoc();
        put(query, UserSchemaKeys.USERID,id);
        DBObject found = getUserCollection().findOne(query);

        if(found == null){
            return null;
        }
        User user = userTypeConverter.converFrom(found);
        return user;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void delete(User user) {
        if(user.getId()!=null) {
            DBObject query = createquery(user.getId());
            getUserCollection().remove(query);
        }
    }

    @Override
    public User update(User user) {
        DBObject query = createquery(user.getId());
        DBObject userDoc = userTypeConverter.converTo(user);
        getUserCollection().findAndModify(query, userDoc);
        return user;
    }

    @Override
    public User save(User user) {
        if(user.getId() == null){
            if(idGenerator ==null)
                throw new IllegalStateException("IdGenerator is null");
        }
        user.setId(idGenerator.generateId() + 100);
        DBObject userDoc = userTypeConverter.converTo(user);
        getUserCollection().insert(userDoc);
        return user;
    }
}
