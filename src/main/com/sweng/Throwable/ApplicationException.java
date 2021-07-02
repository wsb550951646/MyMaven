package sweng.Throwable;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/215:59
 */
public class ApplicationException extends RuntimeException {
    public ApplicationException() {

    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
