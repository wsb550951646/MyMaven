package sweng.Test.TestJson;

import java.sql.Date;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/5/1815:24
 */
public class TestObject {

    private String filename;
    private String filename_encode;
    private String filename_encode_url;
    private float file_size;
    private String file_type;
    private String date;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename_encode() {
        return filename_encode;
    }

    public void setFilename_encode(String filename_encode) {
        this.filename_encode = filename_encode;
    }

    public String getFilename_encode_url() {
        return filename_encode_url;
    }

    public void setFilename_encode_url(String filename_encode_url) {
        this.filename_encode_url = filename_encode_url;
    }

    public float getFile_size() {
        return file_size;
    }

    public void setFile_size(float file_size) {
        this.file_size = file_size;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
