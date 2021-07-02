package sweng.mongodbaccess;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.List;


/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/913:33
 */
public class MongoDBSimpleConnection implements MongoDBConnect {
    private Logger log  = Logger.getLogger(MongoDBSimpleConnection.class);

    private ServerAddress address;
    private List<SimpleMongoCredential> credentials;
    private String dbName;
    private MongoClient mongoClient;

    public MongoDBSimpleConnection(ServerAddress address, List<SimpleMongoCredential> credentials, String dbName) {
        this.address = address;
        this.credentials = credentials;
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    @Override
    public DB getMongoDB() {

        DB db = null;
        if(mongoClient == null){

            LinkedList<MongoCredential> list = new LinkedList<>();
            for(SimpleMongoCredential credential:credentials){
                    list.add(credential.getCredential());
            }
            MongoClient mongoClient = new MongoClient(address, list);
        }
        db = mongoClient.getDB(dbName);
        return db;
    }

    @Override
    public String toString() {
        return "MongoDBSimpleConnection{" +
                "ip=" + address.getHost() +
                ", port=" + address.getPort() +
                ", dbName='" + dbName + '\'' +
                '}';
    }
}
