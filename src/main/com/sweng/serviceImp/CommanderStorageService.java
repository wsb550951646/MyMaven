package sweng.serviceImp;

import sweng.bean.Server;
import sweng.bean.ServerGroup;
import sweng.bean.Storage;
import sweng.service.LocalStorageService;
import sweng.service.RemoteStorageService;
import sweng.service.ServerService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/715:06
 */
public class CommanderStorageService {

    private LocalStorageService localStorageService;
    private RemoteStorageService remoteStorageService;
    private ServerService serverService;
    private final Server commander = new Server();
    private final String bindAddress = "172.17.230.142";

    public LocalStorageService getLocalStorageService() {
        return localStorageService;
    }

    public void setLocalStorageService(LocalStorageService localStorageService) {
        this.localStorageService = localStorageService;
    }

    public RemoteStorageService getRemoteStorageService() {
        return remoteStorageService;
    }

    public void setRemoteStorageService(RemoteStorageService remoteStorageService) {
        this.remoteStorageService = remoteStorageService;
    }

    public ServerService getServerService() {
        return serverService;
    }

    public void setServerService(ServerService serverService) {
        this.serverService = serverService;
    }

    public Server getCommander() {
        return commander;
    }

    //normal_mounted / unmounted / error 的Key都是记录IP的
    public StorageStatus status(Storage storage, Map<String,List<Storage>> allStorages, List<String> normal_mounted, List<String> normal_unmounted,
                                List<String> error, List<ServerGroup> allGroups) {

        List<Storage> localStorages = allStorages.get("localhost");
        Storage storageInCommander = findSameStorage(storage, localStorages);
        if(storageInCommander==null)
        {
            error.add("localhost");
        }else {
            if(storageInCommander.isToMounted() && !storageInCommander.isMounted()){
                error.add("localhost");
            }else if(storageInCommander.isMounted()){
                normal_mounted.add("localhost");
            }else{
                normal_unmounted.add("localhost");
            }
        }

        for(ServerGroup group : allGroups){
            Storage storageInGroup = findStorageInGroup(group, storage);
            process(storageInGroup,allStorages,group,normal_mounted,normal_unmounted,error);
        }
        if(error.size()>0){
            return StorageStatus.ERROR;
        }else {
            //挂载 非挂载都有
            if (normal_mounted.size() > 0 && normal_unmounted.size() > 0) {

                //集群肯定是挂载上的，说明节点的都没有挂
                if (normal_mounted.size() == 1 && normal_mounted.get(0).equals("localhost")) {
                    return StorageStatus.NORMAL_UNMOUNTED;
                } else {
                    //部分节点没有挂上
                    return StorageStatus.NOMRAL_SOME_GROUP_NOT_MOUNTED;
                }
            }

            if (normal_mounted.size() > 0) {
                return StorageStatus.NORMAL_MOUNTED;
            } else {
                return StorageStatus.NORMAL_UNMOUNTED;
            }
        }
    }

    private void process(Storage storage,Map<String,List<Storage>> allStorages,ServerGroup serverGroup,List<String> normal_mounted,
                         List<String> normal_unmounted,List<String> errors) {

        if(storage == null){
          for(Server server : allServers(serverGroup)){
                normal_unmounted.add(server.getIp());
          }
        }else {
            for(Server server : allServers(serverGroup)){
                List<Storage> storageList = allStorages.get(server.getIp());
                Storage storageInServer = findSameStorage(storage, storageList);
                //no exit storage in server
                if(storageInServer==null){
                    errors.add(server.getIp());
                }
                //no mounted in server
                if(!storage.isMounted() && storage.isToMounted()){
                    errors.add(server.getIp());
                }
                if(storage.isMounted()){
                    normal_mounted.add(server.getIp());
                }else {
                    normal_unmounted.add(server.getIp());
                }
            }
        }
    }

    private Storage findStorageInGroup(ServerGroup group,Storage storage) {

        List<Storage> storages = group.getStorages();
        for (Storage each : storages){
            if(each.getId().equals(storage.getId())){
                return each;
            }
        }
        return null;

    }

    private Storage findSameStorage(Storage storage,List<Storage> storageList) {

        for (Storage each : storageList){
            if(each.getName().equals(storage.getName()))
                return each;
        }

        return null;
    }

    public List<String> mount(final Storage storage) {
        final List<String> errors = new LinkedList<String>();
        storage.setToMounted(true);

        List<ServerGroup> allGroups = serverService.list(true);
        for(ServerGroup serverGroup : allGroups){
            Storage storageInGroup = findStorageInGroup(serverGroup, storage);
            if(storageInGroup==null){
                serverGroup.getStorages().add(storage);
            }else {
                int index = serverGroup.getStorages().indexOf(storageInGroup);
                serverGroup.getStorages().set(index, storage);
            }
            //serverService.updateStorage(serverGroup);
        }

        List<Server> allServers = allServers(allGroups);
        allServers.add(commander);
        if(allServers.size()>0){
            ExecutorService otherExecutor = Executors.newFixedThreadPool(allServers.size());
            ExecutorService commandExecutor = Executors.newSingleThreadExecutor();

            for(final Server server : allServers){

                ExecutorService executor = otherExecutor;

                if(server == commander || bindAddress.equals(server.getIp())){
                    executor = commandExecutor;
                }

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (server == commander) {
                                localStorageService.updateStorage(storage);
                                localStorageService.mountStorage(storage);
                            } else {
                                Storage storageByName = remoteStorageService.getRemoteStorageByName(server, storage.getName());
                                if(storageByName!=null){
                                    remoteStorageService.updateStorage(server, storageByName);
                                    remoteStorageService.mountStorage(server, storageByName);
                                }else {
                                    remoteStorageService.addRemoteMounted(server,storage);
                                    remoteStorageService.mountStorage(server, storage);
                                }
                            }

                        }catch (Exception e){
                            errors.add("[" + (server.getIp() == null ? "localhost" : server.getIp()) + "]:" + e.getMessage());
                            System.out.println(e.getStackTrace());
                        }
                    }
                });


            }

            otherExecutor.shutdown();
            commandExecutor.shutdown();
        }


        return errors;
    }

    public List<String> unmount(final Storage storage) {
        final List<String> errors = new LinkedList<String>();
        storage.setToMounted(false);

        List<ServerGroup> allGroups = serverService.list(true);
        for(ServerGroup serverGroup : allGroups){
            Storage storageInGroup = findStorageInGroup(serverGroup, storage);
            if(storageInGroup!=null){
                serverGroup.getStorages().remove(storageInGroup);
            }
        }
        List<Server> allServers = allServers(allGroups);
        allServers.add(commander);
        if(allServers.size()>0) {
            ExecutorService otherExecutor = Executors.newFixedThreadPool(allServers.size());
            ExecutorService commandExecutor = Executors.newSingleThreadExecutor();
            for(final Server server : allServers) {

                ExecutorService executor = otherExecutor;

                if (server == commander || bindAddress.equals(server.getIp())) {
                    executor = commandExecutor;
                }
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (server == commander) {
                                localStorageService.updateStorage(storage);
                                localStorageService.unmountStorage(storage);
                            } else {
                                Storage storageByName = localStorageService.getRemoteStorageByName(storage.getName());
                                if (storageByName != null) {
                                    remoteStorageService.updateStorage(server, storageByName);
                                    remoteStorageService.unmountStorage(server, storageByName);
                                }
                            }
                        }catch (Exception e){
                            System.out.println(e.getStackTrace());
                            errors.add("[" + (server.getIp() == null ? "localhost" : server.getIp()) + "]:" + e.getMessage());
                        }
                    }
                });

            }

            commandExecutor.shutdown();
            otherExecutor.shutdown();
        }
        return errors;
    }

    public enum  StorageStatus{
        NORMAL_MOUNTED, NORMAL_UNMOUNTED, NOMRAL_SOME_GROUP_NOT_MOUNTED, ERROR
    }

    public List<Storage> getStorageList(){

        List<Storage> allRemoteStorages = localStorageService.findAllRemoteStorages();

        return allRemoteStorages;
    }

    public Map<String,List<Storage>> allStorageList(List<ServerGroup> serverGroups) {

        final ConcurrentHashMap<String, List<Storage>> ret = new ConcurrentHashMap<>();
        final List<Storage> localStorageList = localStorageService.findAllRemoteStorages();
        List<Server> allservers = allServers(serverGroups);
        allservers.add(commander);

        if (allservers.size() > 0) {

            ExecutorService executor = Executors.newFixedThreadPool(allservers.size());

            for (final Server server : allservers) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        //server为local的服务
                        if (server == commander) {

                            Map<String, String> moutedMap = new HashMap<>();
                            moutedMap = localStorageService.getRemoteMounted(null);

                            for (Storage each : localStorageList) {
                                each.setMounted(Storage.contains(moutedMap, each));
                            }
                            ret.put("localhost", localStorageList);

                        } else {
                            List<Storage> storages = remoteStorageService.findAllRemoteStoragesByStorageXml(server,null);
                            ret.put(server.getIp(), storages);
                        }
                    }
                });
            }
            executor.shutdown();
            try {
                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            } catch (InterruptedException e) {
                //logger.error(e.getMessage(),e);
                Thread.currentThread().interrupt();
            }
        }
        return ret;

    }

    public List<Server> allServers(ServerGroup serverGroup){

        Map<String,Server> allserver = new HashMap<>();
        List<Server> ret = new LinkedList<>();
        for(Server server : serverGroup.getServers()){
            if(server.getInstallState()!=server.STATE_INSTALL_COMPLETE){
               continue;
            }
            if(!allserver.containsKey(server.getIp())){
                allserver.put(server.getIp(), server);
            }else {
                if(server.isAlive() && !allserver.get(server.getIp()).isAlive()){
                    allserver.put(server.getIp(), server);
                }
            }
        }
        for(Server each:allserver.values()){
            ret.add(each);
        }

        return ret;
    }

    public List<Server> allServers(List<ServerGroup> serverGroup) {

        Map<String,Server> allServer = new HashMap<>();
        for (ServerGroup group : serverGroup){
            for (Server server : group.getServers()){
                if(server.getInstallState() != Server.STATE_INSTALL_COMPLETE)
                    continue;
                if(!allServer.containsKey(server.getIp())){
                    allServer.put(server.getIp(), server);
                }else {
                    if(server.isAlive() && !allServer.get(server.getIp()).isAlive()){
                        allServer.put(server.getIp(), server);
                    }
                }
            }
        }

        List<Server> ret = new LinkedList<>();

        for (Server server : allServer.values()){
            ret.add(server);
        }

        return ret;

    }

}
