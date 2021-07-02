package sweng.dao.user;

import sweng.bean.User;
import com.mongodb.DBObject;
import sweng.mongodbaccess.MongoDbOperationSupport;
import sweng.mongodbaccess.TypeConverter;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/818:33
 */
public class UserTypeConverter extends MongoDbOperationSupport implements TypeConverter<User, DBObject> {


    @Override
    public DBObject converTo(User user) {

        final Integer userId = user.getId();
        final String name = user.getName();
        final String password = user.getPassword();

        DBObject userDoc = createDoc();

        put(userDoc, UserSchemaKeys.USERID, userId);
        put(userDoc, UserSchemaKeys.NAME, name);
        put(userDoc, UserSchemaKeys.PASSWORD,password);

        return userDoc;
    }

    @Override
    public User converFrom(DBObject dbObject) {

        final Integer id = (Integer)dbObject.get(UserSchemaKeys.USERID);
        final String name = (String)dbObject.get(UserSchemaKeys.NAME);
        final String password = (String)dbObject.get(UserSchemaKeys.PASSWORD);

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        return user;
    }



}
