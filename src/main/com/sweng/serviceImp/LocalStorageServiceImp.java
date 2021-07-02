package sweng.serviceImp;

import sweng.bean.Storage;
import sweng.service.LocalStorageService;
import sweng.service.SupportMountTypeAware;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/715:07
 */
public class LocalStorageServiceImp implements LocalStorageService {

    public static List<Storage> localStorages = new LinkedList<>();
    public static HashMap<String,String> localRemoteMounts = new HashMap<String,String>();

    private SupportMountTypeAware supportMountTypeAware;

    private static Integer countId = 0;

    public LocalStorageServiceImp() {
    }

    public SupportMountTypeAware getSupportMountTypeAware() {
        return supportMountTypeAware;
    }

    public void setSupportMountTypeAware(SupportMountTypeAware supportMountTypeAware) {
        this.supportMountTypeAware = supportMountTypeAware;
    }

    static {

        Storage storage = new Storage();
        storage.setId(countId++);
        storage.setType("oss");
        storage.setName("oss_mount_input");
        storage.setPath("//oss-cn-beijing.aliyuncs.com/cloudtranscoder/input");
        storage.setUser("Admin");
        storage.setPwd("1234567");
        storage.setToMounted(true);
        storage.setMounted(true);
        localStorages.add(storage);
        localRemoteMounts.put(storage.getName(), storage.getPath());

        storage = new Storage();
        storage.setId(countId++);
        storage.setType("oss");
        storage.setName("oss_mount_out");
        storage.setPath("//oss-cn-beijing.aliyuncs.com/cloudtranscoder/output");
        storage.setUser("user");
        storage.setPwd("user");
        storage.setMounted(true);
        storage.setToMounted(true);
        localStorages.add(storage);
        localRemoteMounts.put(storage.getName(), storage.getPath());


    }

    public static List<Storage> getLocalStorages() {
        return localStorages;
    }

    public static void setLocalStorages(List<Storage> localStorages) {
        LocalStorageServiceImp.localStorages = localStorages;
    }

    @Override
    public List<Storage> findAllRemoteStorages() {

        return localStorages;
    }

    @Override
    public List<Storage> findAllRemoteStoragesByStorageXml(List<String> mountTypeFilters) {
        return null;
    }

    @Override
    public void addRemoteStorage(Storage st) {
        System.out.println("add stroage: "+st);
        st.setId(countId++);
        localStorages.add(st);
    }

    @Override
    public Storage getRemoteStorage(Integer id) {

        for(Storage storage : localStorages){
            if(storage.getId().equals(id))
                return storage;
        }

        return null;
    }

    @Override
    public Storage getRemoteStorageByName(String name) {

        for (Storage storage : localStorages){
            if(storage.getName().equals(name))
                return storage;
        }

        return null;
    }

    @Override
    public Map<String, String> getRemoteMounted(List<String> mountTypeFilters) {
        return localRemoteMounts;
    }

    @Override
    public void addRemoteMounted(Storage storage) {

        if(storage!=null && !storage.getName().trim().equals("")){
            localRemoteMounts.put(storage.getName(), storage.getPath());
        }
    }

    @Override
    public void removeRemoteMounted(Storage storage) {

        if(storage!=null && !storage.getName().trim().equals("")){
            localRemoteMounts.remove(storage.getName(), storage.getPath());
        }
    }


    @Override
    public void updateStorage(Storage storage) {

        Integer index = 0;
        Integer id = storage.getId();
        Storage oldStorage = new Storage();
        for(Storage each : localStorages){
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
            localStorages.set(index, storage);
        }


    }

    @Override
    public void delStorage(Storage storage) {

        for(Storage each : localStorages)
        {
            if(each.getId().equals(Integer.valueOf(storage.getId()))){
                localStorages.remove(each);
            }
        }
    }

    @Override
    public void mountStorage(Storage storage) {

        //模拟挂载，直接使用设置Mounted为true  在remoteMounts put进去
        for(Storage each : localStorages){
            if(each.getId().equals(Integer.valueOf(storage.getId()))){
                storage.setMounted(true);
                addRemoteMounted(storage);
            }
        }

    }

    @Override
    public void unmountStorage(Storage storage) {

        for(Storage each : localStorages){
            if(each.getId().equals(Integer.valueOf(storage.getId()))){
                storage.setMounted(false);
                removeRemoteMounted(storage);
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
