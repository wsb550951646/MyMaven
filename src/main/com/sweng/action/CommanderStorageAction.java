package sweng.action;

import sweng.bean.ServerGroup;
import sweng.bean.Storage;
import sweng.service.LocalStorageService;
import sweng.service.RemoteStorageService;
import sweng.service.ServerService;
import sweng.serviceImp.CommanderStorageService;

import java.util.*;


/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/219:12
 */
public class CommanderStorageAction extends BaseServerSettingAction {

    private LocalStorageService localStorageService;
    private CommanderStorageService commanderStorageService;
    private RemoteStorageService remoteStorageService;
    protected ServerService serverService;
    private Storage storage;


    private List<Storage> remoteStorageList = new LinkedList<>();
    private List<CommanderStorageService.StorageStatus> statusList = new LinkedList<>();

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public LocalStorageService getLocalStorageService() {
        return localStorageService;
    }

    public void setLocalStorageService(LocalStorageService localStorageService) {
        this.localStorageService = localStorageService;
    }

    public CommanderStorageService getCommanderStorageService() {
        return commanderStorageService;
    }

    public void setCommanderStorageService(CommanderStorageService commanderStorageService) {
        this.commanderStorageService = commanderStorageService;
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

    public List<Storage> getRemoteStorageList() {
        return remoteStorageList;
    }

    public void setRemoteStorageList(List<Storage> remoteStorageList) {
        this.remoteStorageList = remoteStorageList;
    }

    public List<CommanderStorageService.StorageStatus> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<CommanderStorageService.StorageStatus> statusList) {
        this.statusList = statusList;
    }

    public Map<String,String> getSupportedMountTypes(){
        return localStorageService.supportedMountTypesWithAlias();
    }



    public String get(){
        System.out.println("OK get");
        try {
            remoteStorageList = commanderStorageService.getStorageList();
            List<ServerGroup> allGroups = serverService.list(true);
            Map<String, List<Storage>> allStorageList = commanderStorageService.allStorageList(allGroups);

            for (Storage storage : remoteStorageList) {
                LinkedList<String> errors = new LinkedList<>();
                LinkedList<String> normal_mount = new LinkedList<>();
                LinkedList<String> normal_unmount = new LinkedList<>();
                CommanderStorageService.StorageStatus status = commanderStorageService.status(storage, allStorageList, normal_mount, normal_unmount, errors, allGroups);
                statusList.add(status);
            }
        }catch (Exception e){
            addActionError(e.toString());
            System.out.println(e.getStackTrace());
            return ERROR;
        }
        return SUCCESS;
    }

    public String add(){

        System.out.println("add storage:"+storage);

        if(storage==null)
            return ERROR;

        localStorageService.addRemoteStorage(storage);
        return SUCCESS;

    }

    public String update(){

        System.out.println("update");

        if(storage==null){
            return ERROR;
        }

        localStorageService.updateStorage(storage);

        return SUCCESS;
    }

    public String delete(){

        System.out.println("delete");

        if(storage.getId()==null)
            return ERROR;

        localStorageService.delStorage(storage);

        return SUCCESS;
    }

    public String mount(){

        System.out.println("mount storage:"+storage.getId());

        if(storage.getId() == null)
            return ERROR;

        storage = localStorageService.getRemoteStorage(storage.getId());
        if(storage!=null){
            if (storage.getName() != null && storage.getName().trim().equals("")) {
                addActionError("storage name is empty");
            }else {
                List<String> errors = commanderStorageService.mount(storage);
                if (!errors.isEmpty()) {
                    StringBuilder builder = new StringBuilder();
                    for (String error : errors) {
                        builder.append(error);
                        builder.append("\n");
                    }
                    addActionError(builder.toString());
                }
            }

        }
        return SUCCESS;
    }

    public String unmount(){

        System.out.println("unmount storage Id:"+storage.getId());

        if(storage.getId()==null)
            return ERROR;
        storage = localStorageService.getRemoteStorage(storage.getId());
        if(storage!=null){
            if(storage.getName()!=null && storage.getName().trim().equals("")){
                addActionError("storage name is empty");
            }else {
                List<String> errors = commanderStorageService.unmount(storage);
                if (!errors.isEmpty()) {
                    StringBuilder builder = new StringBuilder();
                    for (String error : errors) {
                        builder.append(error);
                        builder.append("\n");
                    }
                    addActionError(builder.toString());
                }
            }
        }

        return SUCCESS;
    }



}
