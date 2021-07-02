package sweng.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/3/2717:38
 */
public class Server {

    /**
     * Indicate there has no task running in the server.
     */
    public static final int STATE_FREE = 0;

    /**
     * Indicate there some tasks are running in the server.
     */
    public static final int STATE_BUSY = 1;

    /**
     * Indicate there are some tasks failed.
     */
    public static final int STATE_ERROR = 2;

    /**
     * Indicate install NONE.
     */
    public static final int STATE_INSTALL_NONE = 0;

    /**
     * Indicate install ERROR.
     */
    public static final int STATE_INSTALL_ERROR = 1;

    /**
     * Indicate install RUNNING.
     */
    public static final int STATE_INSTALL_RUNNING = 2;

    /**
     * Indicate install COMPLETE.
     */
    public static final int STATE_INSTALL_COMPLETE = 3;

    /**
     * Indicate APP install COMPLETE.
     */
    public static final int STATE_APP_INSTALL_COMPLETE = 4;

    /**
     * Indicate Agent code type.
     */
    public static final int CODEC_TYPE_GPU = 0;

    /**
     * Indicate Agent code type.
     */
    public static final int CODEC_TYPE_CPU = 1;

    /**
     * Indicate Agent code type.
     */
    public static final int CODEC_TYPE_UNKNOWN = -1;

    private String id;
    private Integer type;
    private String name;
    private String ip;
    private Integer port = 0;
    private Integer state;
    private boolean backup;
    private ServerGroup group;
    private boolean added;
    private boolean alive;
    private boolean enabled = false;
    private Integer installState = STATE_INSTALL_NONE;
  // private ServerCapabilities capabilities;
    private Integer maxLimitedTasks;
    private Integer transcodingType;
    private Integer currentTasks;
    private Integer errorCode = 0;
    private String lastError = "";
    private Map<String, String> userData = new HashMap<String,String>();
    private int codecType = CODEC_TYPE_UNKNOWN;

    /**
     * Default construct.
     */
    public Server() {

    }

    /**
     * Construct server with the specified node description.
     *
     * @param desc
     */

    /**
     * Return the server id.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the server id.
     *
     * @param id
     *            - the server id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Return the server name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the server name.
     *
     * @param name
     *            - the server name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the server ip.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Set the server ip.
     *
     * @param ip
     *            - the server ip.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Returns the server port.
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Set the server port.
     *
     * @param port
     *            - the server port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Return the server state.
     */
    public Integer getState() {
        return state;
    }

    /**
     * Set the server state.
     *
     * @param state
     *            - the state to be set
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * Returns the server type.
     *
     */
    public Integer getType() {
        return type;
    }

    /**
     * Set the server type.
     *
     * @param type
     *            - the server type.
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Indicate the server is added or not. - For servers in database, it is
     * true. - For other servers, it is false.
     */
    public boolean isAdded() {
        return added;
    }

    /**
     * Set the server is added or not.
     *
     * @param added
     *            - the flag to be set
     */
    public void setAdded(boolean added) {
        this.added = added;
    }

    /**
     * Indicate the server is alive or not.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Set the server is alive or not.
     *
     * @param alive
     *            - the alive flag to bet set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Indicate the server is enabled or not
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set the server is enabled or not.
     *
     * @param enabled
     *            - the enabled flag to be set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Returns the group this server belongs to.
     */
    public ServerGroup getGroup() {
        return group;
    }

    /**
     * Set the server group.
     *
     * @param group
     *            - the server group
     */
    public void setGroup(ServerGroup group) {
        this.group = group;
    }

    /**
     * Indicate the server is a backup server.
     */
    public boolean isBackup() {
        return backup;
    }

    /**
     * Set the backup flag.
     *
     * @param backup
     *            - the backup flag.
     */
    public void setBackup(boolean backup) {
        this.backup = backup;
    }


    /**
     * Returns the max limited tasks count.
     */
    public Integer getMaxLimitedTasks() {
        return maxLimitedTasks;
    }

    /**
     * Set the max limited tasks count.
     *
     * @param maxLimitedTasks
     *            - the count to set
     */
    public void setMaxLimitedTasks(Integer maxLimitedTasks) {
        this.maxLimitedTasks = maxLimitedTasks;
    }

    public Integer getTranscodingType() {
        return transcodingType;
    }

    public void setTranscodingType(Integer transcodingType) {
        this.transcodingType = transcodingType;
    }

    public Integer getCurrentTasks() {
        return currentTasks;
    }

    public void setCurrentTasks(Integer currentTasks) {
        this.currentTasks = currentTasks;
    }

    public Integer getInstallState() {
        return installState;
    }

    public void setInstallState(Integer installState) {
        this.installState = installState;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getLastError() {
        return lastError;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public Map<String, String> getUserData() {
        return userData;
    }

    public void setUserData(Map<String, String> userData) {
        this.userData = userData;
    }

    public int getCodecType() {
        return codecType;
    }

    public void setCodecType(int codecType) {
        this.codecType = codecType;
    }

}
