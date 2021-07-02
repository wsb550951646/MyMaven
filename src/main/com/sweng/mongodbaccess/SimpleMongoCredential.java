package sweng.mongodbaccess;

import com.mongodb.MongoCredential;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/913:42
 */
public class SimpleMongoCredential {

    private MongoCredential credential;

    public SimpleMongoCredential(String userName,String passWord,String db) {
        this.credential = MongoCredential.createCredential(userName, db, passWord.toCharArray());
    }

    public MongoCredential getCredential(){
        return this.credential;
    }
}
