package com.yoong.junior.community.network.http;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Desc java实现HTTP请求的三种方式
 * PS：GET、POST区别；
 * https://www.cnblogs.com/hhhshct/p/8523697.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年3月14日19:56:57
 * <p>
 * @Version 1.0
 */
public class HttpUtilsPlus {

    private static String local = "http://127.0.0.1:8095/push/login";
    private static String baidu = "http://www.baidu.com";
    private static String imgUrl = "http://zacdn-image.cgw360.com/cgw360/cls/credit/603a4e09-77e5-44ad-b096-d02ff2384d2f.jpg";
    private static String uri = "http://zacdn-image.cgw360.com/cgw360/cls/credit/603a4e09-77e5-44ad-b096-d02ff2384d2f.jpg";
    private static String filePath = "D:\\Temp\\IO\\image01.jpg";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            httpUrlConnectionGet();
            httpUrlConnectionPost();

            httpClientGet();
            httpClientPost();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * HttpURLConnection GET
     */
    public static void httpUrlConnectionGet() throws Exception {
        URL url = new URL(baidu);
        URLConnection conn1 = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(15000);
        conn.setReadTimeout(15000);
        //发送请求
        conn.connect();
        int code = conn.getResponseCode();
        if (code == 200) {
            // 从流中读取响应信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line + "\r\n");
            }
            System.out.println(result.toString());
            reader.close();
            conn.disconnect();
        }
    }

    /**
     * HttpURLConnection POST
     */
    public static void httpUrlConnectionPost() throws Exception {
        String params = "input";
        URL url = new URL(baidu);
        URLConnection conn1 = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(15000);
        conn.setReadTimeout(15000);
        conn.setRequestProperty("Content-Type", "application/json");
        OutputStream os = conn.getOutputStream();
        os.write(params.getBytes());

        int code = conn.getResponseCode();
        if (code == 200) {
            // 从流中读取响应信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line + "\r\n");
            }
            System.out.println(result.toString());
            reader.close();
            conn.disconnect();
        }
    }

    /**
     * HttpClient - Get
     */
    public static void httpClientGet() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpClient httpClient02 = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(local);
        CloseableHttpResponse httpResponse = null;
        httpResponse = httpClient.execute(httpGet);
        System.out.println(httpResponse.getStatusLine());
        System.out.println(HttpStatus.SC_OK);

        HttpEntity entity = httpResponse.getEntity();// 5. 处理响应实体
        if (entity != null) {
            System.out.println("长度：" + entity.getContentLength());
            System.out.println("内容：" + EntityUtils.toString(entity));
        }
        httpResponse.close();
        httpClient.close();
    }


    /**
     * HttpClient - Post
     */
    public static void httpClientPost() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpClient httpClient02 = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(local);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/json");
        StringEntity string = new StringEntity("{'key':'value'}", "UTF-8");
        httpPost.setEntity(string);

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        System.out.println(httpResponse.getStatusLine());
        System.out.println(HttpStatus.SC_OK);

        HttpEntity entity = httpResponse.getEntity();// 5. 处理响应实体
        if (entity != null) {
            System.out.println("长度：" + entity.getContentLength());
            System.out.println("内容：" + EntityUtils.toString(entity));
        }
        httpResponse.close();
        httpClient.close();
    }
}