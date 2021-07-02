package sweng.dao.server;

import sweng.bean.Server;
import sweng.bean.ServerGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/716:12
 */
public class ServerDaoMock implements ServerDao {

    private static List<Server> servers = new LinkedList<>();

    static {

        ServerGroup serverGroup = new ServerGroup();
        serverGroup.setId(1);
        serverGroup.setName("Test1");
        serverGroup.setType(ServerGroup.TYPE_DEFAULT);
        serverGroup.setShareType(ServerGroup.SHARE_TYPE_NONE);


        Server server = new Server();
        server.setType(Server.CODEC_TYPE_CPU);
        server.setInstallState(Server.STATE_INSTALL_COMPLETE);
        server.setGroup(serverGroup);
        server.setIp("172.17.230.142");

        Server server1 = new Server();
        server1.setGroup(serverGroup);
        server1.setType(Server.CODEC_TYPE_CPU);
        server1.setInstallState(Server.STATE_INSTALL_COMPLETE);
        server1.setIp("172.17.229.89");

        servers.add(server);
        servers.add(server1);

    }

    @Override
    public List<Server> listAll() {
        return servers;
    }

    @Override
    public List<Server> getServersInGroup(Integer groupId) {
        List<Server> selected = new LinkedList<>();
        for (Server each : servers){
            if(each.getGroup().getId().equals(groupId)){
                selected.add(each);
            }
        }

        return selected;
    }

    @Override
    public Server getServer(String id) {

        for(Server each : servers){
            if(each.getId().equals(id)){
                return each;
            }
        }
        return null;
    }
}
