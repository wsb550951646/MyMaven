package sweng.dao.server;

import sweng.bean.Server;
import sweng.bean.ServerGroup;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/715:23
 */
public interface ServerGroupDao {

    List<ServerGroup> list();

    ServerGroup getGroup(Integer id);

    void updateServerGroup(ServerGroup serverGroup);

}
