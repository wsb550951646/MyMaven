package sweng.dao.server;

import sweng.bean.Server;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/715:24
 */
public interface ServerDao {

    List<Server> listAll();

    List<Server> getServersInGroup(Integer groupId);

    Server getServer(String id);


}
