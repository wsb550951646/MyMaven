package sweng.mongodbaccess;

import java.io.Serializable;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/917:10
 */
public interface IdGenerator<T extends Serializable> {

    T generateId();

}
