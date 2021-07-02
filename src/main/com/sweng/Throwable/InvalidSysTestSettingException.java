package sweng.Throwable;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/215:56
 */
public class InvalidSysTestSettingException extends ApplicationException{

    public InvalidSysTestSettingException() {
    }

    public InvalidSysTestSettingException(String message) {
        super(message);
    }

    public InvalidSysTestSettingException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSysTestSettingException(Throwable cause) {
        super(cause);
    }
}
