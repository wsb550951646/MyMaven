package sweng.utils.IO;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/5/1916:53
 */
public class InputStreamUtil {
    private static Logger logger = Logger.getLogger(InputStreamUtil.class);
    public final static byte[] toByteArray(InputStream in) {
        byte[] buff = null;

        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            int count = 0;

            while ((count = in.read(temp)) > 0) {
                outStream.write(temp, 0, count);
            }

            outStream.close();
            buff = outStream.toByteArray();
        }
        catch (IOException e) {
            logger.error(null,e);
        }

        return buff;
    }
}
