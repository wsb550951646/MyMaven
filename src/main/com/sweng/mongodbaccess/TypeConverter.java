package sweng.mongodbaccess;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/614:13
 */
public interface TypeConverter<S,T> {

    T converTo(S s);
    S converFrom(T t);

}
