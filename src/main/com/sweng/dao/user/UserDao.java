package sweng.dao.user;

import sweng.bean.User;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/819:02
 */
public interface UserDao {

    User get(Integer id);

    List<User> getAll();

    void delete(User id);

    User update(User user);

    User save(User user);


}
