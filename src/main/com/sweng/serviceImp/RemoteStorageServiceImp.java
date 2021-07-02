package sweng.serviceImp;

import sweng.bean.Server;
import sweng.bean.Storage;
import sweng.service.RemoteStorageService;
import sweng.service.SupportMountTypeAware;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/718:27
 */
public class RemoteStorageServiceImp implements RemoteStorageService {

    public static Integer countId = 0;

    public static List<Storage> remoteStorageList = new LinkedList<>();
    public static HashMap<String,String> remoteMounts = new HashMap<String,String>();

    static {

        Storage storage = new Storage();
        storage.setId(countId++);
        storage.setType("oss");
        storage.setName("oss_mount_input");
        storage.setPath("//oss-cn-beijing.aliyuncs.com/cloudtranscoder/input");
        storage.setUser("9527");
        storage.setPwd("1234567");
        storage.setToMounted(true);
        storage.setMounted(true);
        remoteStorageList.add(storage);
        remoteMounts.put(storage.getName(), storage.getPath());

        storage = new Storage();
        storage.setId(countId++);
        storage.setType("oss");
        storage.setName("oss_mount_out");
        storage.setPath("//oss-cn-beijing.aliyuncs.com/cloudtranscoder/output");
        storage.setUser("user");
        storage.setPwd("password");
        storage.setMounted(true);
        storage.setToMounted(true);
        remoteStorageList.add(storage);
        remoteMounts.put(storage.getName(), storage.getPath());

    }

    private SupportMountTypeAware supportMountTypeAware;

    public RemoteStorageServiceImp() {
    }

    public SupportMountTypeAware getSupportMountTypeAware() {
        return supportMountTypeAware;
    }

    public void setSupportMountTypeAware(SupportMountTypeAware supportMountTypeAware) {
        this.supportMountTypeAware = supportMountTypeAware;
    }


    @Override
    public List<Storage> findAllRemoteStorages(Server agent) {
        //模拟远程连接agent的Ip
        return remoteStorageList;
    }

    @Override
    public List<Storage> findAllRemoteStoragesByStorageXml(Server agent,List<String> mountTypeFilters) {

        List<Storage> ret = new LinkedList<>();
        //从底层
        Map<String, String> remoteMounted = getRemoteMounted(agent, mountTypeFilters);
        //从数据库拿
        List<Storage> allRemoteStorages = findAllRemoteStorages(agent);

        for(Storage each : allRemoteStorages){
            each.setMounted(false);
            if(remoteMounted.containsKey(each.getName())){
                each.setMounted(true);
                ret.add(each);
            }
        }
        return ret;
    }

    @Override
    public Storage getRemoteStorageByName(Server agent, String name) {

        List<Storage> allRemoteStorages = findAllRemoteStorages(agent);
        Storage ret = null;
        for(Storage storage : allRemoteStorages){
            if(storage.getName().equals(name)) {
                ret = storage;
                break;
            }
        }
        return ret;
    }

    //从底层的获取的remote mount
    @Override
    public Map<String, String> getRemoteMounted(Server agent, List<String> supportMountTypeAwares) {
        return remoteMounts;
    }

    @Override
    public void addRemoteMounted(Server agent, Storage storage) {
        if(storage!=null && !storage.getName().trim().equals("")){
           remoteStorageList.add(storage);
        }
    }

    @Override
    public void updateStorage(Server agent, Storage storage) {

        Integer index = 0;
        Integer id = storage.getId();
        Storage oldStorage = new Storage();
        for(Storage each : remoteStorageList){
            if(each.getId().equals(Integer.valueOf(id))){
                oldStorage.setId(each.getId());
                oldStorage.setName(each.getName());
                oldStorage.setPath(each.getPath());
                oldStorage.setUser(each.getUser());
                oldStorage.setPwd(each.getPwd());
                oldStorage.setOptions(each.getOptions());
                oldStorage.setType(each.getType());
                oldStorage.setToMounted(each.isToMounted());
                break;
            }
            index++;
        }

        if(oldStorage!=null && !oldStorage.equals(storage)){
            remoteStorageList.set(index, storage);
        }

    }

    @Override
    public void mountStorage(Server agent, Storage storage) {
        //模拟挂载，直接使用设置Mounted为true  在remoteMounts put进去
        for(Storage each : remoteStorageList){
            if(each.getId().equals(Integer.valueOf(storage.getId()))){
                storage.setMounted(true);
                remoteMounts.put(storage.getName(), storage.getPath());
            }
        }
    }

    @Override
    public void unmountStorage(Server agent, Storage storage) {

        for(Storage each : remoteStorageList){
            if(storage.getId().equals(Integer.valueOf(each.getId()))){
                storage.setMounted(false);
                remoteMounts.remove(storage.getName(), storage.getPath());
            }
        }

    }

    @Override
    public Map<String, String> supportedMountTypesWithAlias() {
        return supportMountTypeAware.supportedMountTypesWithAlias();
    }

    @Override
    public List<String> supportedMountTypes() {
        return supportMountTypeAware.supportedMountTypes();
    }

}
