package sweng.MINIO.test;

import io.minio.MinioClient;
import io.minio.errors.MinioException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/8/1910:31
 */
public class FileUploader {

    public static void main(String[] args) {

        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient("http://172.17.229.217:9000", "AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMIK7MDENGbPxRfiCYEXAMPLEKEY");

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("sweng");
            if(isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("asiatrip");
            }

            /*
                使用putObject上传一个文件到存储桶中。  bucketName 存储桶里的对象名称。 File name.
             */
            minioClient.putObject("sweng","xx/test.jpg", "C:\\Users\\sweng.ARCVIDEO\\Desktop\\zt.png",null);

            System.out.println("/home/user/Photos/asiaphotos.zip is successfully uploaded as asiaphotos.zip to `asiatrip` bucket.");
        } catch(Exception e) {
            System.out.println("Error occurred: " + e);
        }
    }

}


