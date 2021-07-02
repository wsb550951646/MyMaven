package sweng.utils.http;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import sweng.utils.IO.InputStreamUtil;


import java.io.InputStream;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/5/1916:46
 */
public class httputils {

    private static Integer connectTimeout = 40000;
    private static Integer soTimeout = 40000;

    public static String httpPostWithJson(String uri,String json){

        PostMethod postMethod = new PostMethod(uri);
        HttpPost httpPost = new HttpPost(uri);

        HttpClient client = new HttpClient();
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpConnectionManagerParams managerParams = client.getHttpConnectionManager().getParams();
        managerParams.setConnectionTimeout(connectTimeout);

        managerParams.setSoTimeout(soTimeout);

        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        String result = "";

        //设置json格式
        RequestEntity requestEntity = null;
        StringEntity stringEntity = null;
        try {
            requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");
            stringEntity = new StringEntity(json, "UTF-8");
            stringEntity.setContentType("application/json");
            stringEntity.setContentEncoding("UTF-8");

            postMethod.setRequestEntity(requestEntity);
            httpPost.setEntity(stringEntity);

            int statusCode = client.executeMethod(postMethod);
            httpClient.execute(httpPost);

            if (statusCode != HttpStatus.SC_OK) {
                return "";
            }
            //获取返回的信息
            byte[] buff = null;
            InputStream in = postMethod.getResponseBodyAsStream();
            buff = InputStreamUtil.toByteArray(in);
            if (buff == null || buff.length == 0) {
                return "";
            }
            result = new String(buff, "UTF-8");
        } catch (Exception e) {

        }

        return result;
    }


}
