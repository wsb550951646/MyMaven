package sweng.dao.server;

import sweng.bean.ServerGroup;
import sweng.bean.Storage;
import sweng.serviceImp.LocalStorageServiceImp;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/716:15
 */
public class ServerGroupDaoMock implements ServerGroupDao {

    private static List<ServerGroup> groups = new LinkedList<>();
    private static int id = 1;

    static {
        //这里设置只有一个组  Test1 id=1 组里含有存储StorageList
        ServerGroup group = new ServerGroup();
        group.setId(id++);
        group.setName("Test1");
        group.setType(ServerGroup.TYPE_DEFAULT);
        group.setShareType(ServerGroup.SHARE_TYPE_NONE);
        List<Storage> storageList = cloneStorage(LocalStorageServiceImp.getLocalStorages());
        group.setStorages(storageList);
        groups.add(group);
    }

    @Override
    public List<ServerGroup> list() {
        return groups;
    }

    @Override
    public ServerGroup getGroup(Integer id) {

        for(ServerGroup each : groups){
            if(each.getId().equals(id)){
                return each;
            }
        }

        return null;

    }

    @Override
    public void updateServerGroup(ServerGroup serverGroup) {

        //该方法主要将缓存serverGroup的storageList 保存到数据库中。
        for(ServerGroup each : groups){
            if(each.getId().equals(Integer.valueOf(serverGroup.getId()))){
                each.getStorages().clear();
                each.setStorages(serverGroup.getStorages());
            }
        }
    }

    public static List<Storage> cloneStorage(List<Storage> storageList){

        LinkedList<Storage> ret = new LinkedList<>();

        for(Storage each : storageList){

            Storage storage = new Storage();
            storage.setMounted(each.isMounted());
            storage.setToMounted(each.isToMounted());
            storage.setId(each.getId());
            storage.setName(each.getName());
            storage.setPath(each.getPath());
            storage.setUser(each.getUser());
            storage.setPwd(each.getPwd());
            storage.setType(each.getType());
            storage.setOptions(each.getOptions());
            ret.add(storage);
        }
        return ret;
    }

}
