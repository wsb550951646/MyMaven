package sweng.serviceImp;

import sweng.bean.Server;
import sweng.bean.ServerGroup;
import sweng.dao.server.ServerDao;
import sweng.dao.server.ServerGroupDao;
import sweng.service.ServerService;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/715:07
 */
public class ServerServiceImp implements ServerService {

    private ServerDao serverDao;
    private ServerGroupDao serverGroupDao;

    public ServerDao getServerDao() {
        return serverDao;
    }

    public void setServerDao(ServerDao serverDao) {
        this.serverDao = serverDao;
    }

    public ServerGroupDao getServerGroupDao() {
        return serverGroupDao;
    }

    public void setServerGroupDao(ServerGroupDao serverGroupDao) {
        this.serverGroupDao = serverGroupDao;
    }

    @Override
    public List<ServerGroup> list(boolean isIncludeServers) {

        List<ServerGroup> allGroups = serverGroupDao.list();

        //填充 serverGroup 和 server
        if(isIncludeServers && allGroups!=null){
            for (ServerGroup serverGroup : allGroups){
                List<Server> serversInGroup = serverDao.getServersInGroup(serverGroup.getId());
                for(Server server : serversInGroup){
                    server.setGroup(serverGroup);
                }
                serverGroup.setServers(serversInGroup);
            }
        }
        return allGroups;
    }

    @Override
    public ServerGroup getGroup(Integer id, boolean isIncludeServers) {
        return null;
    }

    @Override
    public Server getServer(String id) {
        return null;
    }

    @Override
    public void updateStorage(ServerGroup serverGroup) {
        serverGroupDao.updateServerGroup(serverGroup);
    }
}
