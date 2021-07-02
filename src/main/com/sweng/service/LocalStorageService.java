package sweng.service;

import sweng.bean.Storage;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/715:01
 */
public interface LocalStorageService extends SupportMountTypeAware{

    List<Storage> findAllRemoteStorages();
    List<Storage> findAllRemoteStoragesByStorageXml(List<String> mountTypeFilters);

    void addRemoteStorage(Storage st);

    Storage getRemoteStorage(Integer id);

    Storage getRemoteStorageByName(String name);

    Map<String, String> getRemoteMounted(List<String> mountTypeFilters);

    void addRemoteMounted(Storage storage);

    void removeRemoteMounted(Storage storage);

    void updateStorage(Storage storage);

    void delStorage(Storage storage);

    void mountStorage(Storage storage);

    void unmountStorage(Storage storage);


}
