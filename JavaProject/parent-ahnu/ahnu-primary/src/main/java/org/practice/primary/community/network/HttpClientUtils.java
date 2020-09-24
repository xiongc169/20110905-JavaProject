package org.practice.primary.community.network;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc HttpClient 网络编程
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020年9月24日
 * <p>
 * @Version 1.0
 */
public class HttpClientUtils {

    private static final String UTF_8 = "UTF-8";

    private static final String ContentType = "Content-Type";

    private static final String ApplicationJson = "application/json";

    private static final String FormData = "application/x-www-form-urlencoded";

    private static RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(30000)
            .setConnectTimeout(30000)
            .setSocketTimeout(50000)
            .build();

    /**
     * Get方法
     */
    public static String get(String url) {
        //log.info("Get入参：{}", url);
        String response = null;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            //log.info("响应结果：{}", JSON.toJSONString(httpResponse));
            if (httpResponse != null) {
                if (httpResponse.getStatusLine() != null) {
                    //log.info("响应码：{}", httpResponse.getStatusLine().getStatusCode());
                }
                if (httpResponse.getEntity() != null) {
                    response = EntityUtils.toString(httpResponse.getEntity());
                    //log.info("响应报文：{}", response);
                }
            }
        } catch (Exception ex) {
            //log.error("Get异常", ex);
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (Exception ex) {
                    //log.error("关闭httpClient异常", ex);
                }
            }
        }
        return response;
    }

    /**
     * Post方法
     */
    public static String postJSON(String url, String params) {
        //log.info("PostJSON入参：{} {}", url, params);
        String response = null;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(ContentType, ApplicationJson);
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new StringEntity(params, UTF_8));
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            //log.info("响应结果：{}", JSON.toJSONString(httpResponse));
            if (httpResponse != null) {
                if (httpResponse.getStatusLine() != null) {
                    //log.info("响应码：{}", httpResponse.getStatusLine().getStatusCode());
                }
                if (httpResponse.getEntity() != null) {
                    response = EntityUtils.toString(httpResponse.getEntity());
                    //log.info("响应报文：{}", response);
                }
            }
        } catch (Exception ex) {
            //log.error("PostJSON异常", ex);
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (Exception ex) {
                    //log.error("关闭httpClient异常", ex);
                }
            }
        }
        return response;
    }

    /**
     * Post方法
     */
    public static String postFormData(String url, Map<String, String> params) throws Exception {
        //log.info("PostFormData入参：{} {}", url, params);
        String response = null;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(ContentType, FormData);
            httpPost.setConfig(requestConfig);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, UTF_8));
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            //log.info("响应结果：{}", JSON.toJSONString(httpResponse));
            if (httpResponse != null) {
                if (httpResponse.getStatusLine() != null) {
                    //log.info("响应码：{}", httpResponse.getStatusLine().getStatusCode());
                }
                if (httpResponse.getEntity() != null) {
                    response = EntityUtils.toString(httpResponse.getEntity());
                    //log.info("响应报文：{}", response);
                }
            }
        } catch (Exception ex) {
            //log.error("PostFormData异常", ex);
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (Exception ex) {
                    //log.error("关闭httpClient异常", ex);
                }
            }
        }
        return response;
    }

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Charset charset = Charset.forName(UTF_8);

            String url = "http://localhost:8085/user/login?name=123456";
            get(url);

            String url02 = "http://localhost:8085/user/register?userName=name01&password=password01";
            get(url02);

            //服务端用 @RequestBody 标注入参
            String url03 = "http://localhost:8085/user/register";
            String paramJson = "{\"userName\":\"userName01\",\"password\":\"password01\"}";
            postJSON(url03, paramJson);

            //服务端不用 @RequestBody 标注入参
            String url04 = "http://localhost:8085/user/logout";
            HashMap<String, String> paramMap = new HashMap();
            paramMap.put("userName", "userName01");
            paramMap.put("password", "password01");
            postFormData(url04, paramMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
