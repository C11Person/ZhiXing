package cn.zx.util;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.ConnectionPoolTimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;


/**
 * HTTP 请求
 */
public class HttpServer {

    private static CloseableHttpClient httpClient = buildHttpClient();

    private static int socketTimeout = 5000;

    private static int connectTimeout = 5000;

    private static int requestTimeout = 5000;

    public static CloseableHttpClient buildHttpClient() {

        try {
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout)
                    .setConnectionRequestTimeout(requestTimeout).setSocketTimeout(socketTimeout).build();

            httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig)
                    // .setSSLSocketFactory(sslsf)
                    .build();

            return httpClient;
        } catch (Exception e) {
            throw new RuntimeException("error create httpclient......", e);
        }
    }

    public static String doGet(String requestUrl) throws Exception {
        HttpGet httpget = new HttpGet(requestUrl);
        try {

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };

            return httpClient.execute(httpget, responseHandler);
        } finally {
            httpget.releaseConnection();
        }
    }

    public static String doPost(String url, Map parmaMap) {

        String result = null;

        HttpPost httpPost = new HttpPost(url);

        StringEntity postEntity = new StringEntity(JSON.toJSONString(parmaMap), "UTF-8");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(postEntity);


        try {
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        }  catch (Exception e) {

        } finally {
            httpPost.releaseConnection();
        }

        return result;
    }

    public static String doPost(String url, Map<String, Object> heads, Map parmaMap) {

        String result = null;

        HttpPost httpPost = new HttpPost(url);

        StringEntity postEntity = new StringEntity(JSON.toJSONString(parmaMap), "UTF-8");
        for (String key : heads.keySet()) {
            httpPost.addHeader(key, heads.get(key).toString());
        }
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(postEntity);
        try {
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        }  catch (ConnectTimeoutException e) {

        } catch (SocketTimeoutException e) {

        } catch (Exception e) {

        } finally {
            httpPost.releaseConnection();
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        // 发送 GET 请求
        String s = HttpServer.doGet("http://localhost");
        System.out.println(s);
        Map paramMap = new HashMap();
        // 发送 POST 请求
        String sr = HttpServer.doPost("http://localhost", paramMap);
        System.out.println(sr);
    }

}