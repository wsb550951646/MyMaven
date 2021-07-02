package sweng.service;

import sweng.bean.Server;
import sweng.bean.ServerGroup;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/715:03
 */
public interface ServerService {

    List<ServerGroup> list(boolean isIncludeServers);

    ServerGroup getGroup(Integer id, boolean isIncludeServers);

    Server getServer(String id);

    void updateStorage(ServerGroup serverGroup);

}
