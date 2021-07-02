package sweng.service;

import sweng.bean.Server;
import sweng.bean.Storage;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/718:25
 */
public interface RemoteStorageService extends SupportMountTypeAware {

    List<Storage> findAllRemoteStorages(Server agent);
    List<Storage> findAllRemoteStoragesByStorageXml(Server agent,List<String> mountTypeFilters);

    Storage getRemoteStorageByName(Server agent,String name);

    Map<String,String> getRemoteMounted(Server agent,List<String> supportMountTypeAwares);

    void addRemoteMounted(Server agent,Storage storage);

    void updateStorage(Server agent , Storage storage);

    void mountStorage(Server agent , Storage storage);

    void unmountStorage(Server agent , Storage storage);


}
