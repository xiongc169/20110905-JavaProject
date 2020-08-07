package org.practice.primary.community.network.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @Desc 电子合同-查询合同模板
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020年5月26日
 * <p>
 * @Version 1.0
 */
public class HttpUtilsCs {

    private static final String GetTemplateList = "http://127.0.0.1:9855/api/v1/getTemplateList";
    private static final String RequestBodyMenu = "http://127.0.0.1:7095/param/requestBodyMenu";
    private static final String CONTENT_TYPE = "application/json";
    private static final int CONNECT_TIMEOUT = 30000;
    private static final int CONNECTION_REQUEST_TIMEOUT = 5000;
    private static final int SOCKET_TIMEOUT = 60000;
    private static final String CHAR_SET = "UTF-8";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            restTemplateDemo();

            String json = "{\"appId\":\"ftcs-test\",\"body\":\"BYprHoNf7CPKJ32xhe6BUoC+QUJkGnKwU46Wp8z4VsaWg/2Sixam5fVMZ41Q/wKPB5AH8ZbPXwtIbHJUNNhGYiG3GG76z4MCOlvR8FmzrRgzFRstOEK2C5LQ8/uZNKwUGx2pIwaSOv3xuKjnzgwZ5WmFD7MUqhRN4I+jRc2IsDQ=\",\"sequenceId\":\"2020-05-26 16:41:46\",\"sign\":\"4478c43f955a752a8836ae4282b06752\"}";
            String result = sendPostRequestJSON(GetTemplateList, json);
            System.out.println(result);

            requestParamTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void restTemplateDemo() throws Exception {
        String json0601 = "{\"menuId\":1111,\"menuName\":\"menuName-01\",\"menuUrl\":\"menuUrl-01\"}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(RequestBodyMenu, json0601);

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        ClientHttpRequest request = requestFactory.createRequest(new URI("111"), HttpMethod.GET);
        ClientHttpResponse response = request.execute();
        System.out.println(response.getStatusCode());
    }

    public static String sendPostRequestJSON(String requestUrl, String json) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse res = null;
        try {
            HttpPost post = new HttpPost(requestUrl);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
            post.setConfig(requestConfig);
            // 将JSON进行UTF-8编码,以便传输中文
            StringEntity string = new StringEntity(json, CHAR_SET);
            string.setContentEncoding(CHAR_SET);
            string.setContentType(CONTENT_TYPE);
            post.setEntity(string);
            res = client.execute(post);
            System.out.println("res.getStatusLine():" + res.getStatusLine().getStatusCode());
            if (res.getStatusLine().getStatusCode() == 200) {
                String result = EntityUtils.toString(res.getEntity());
                return result;
            } else {
                return null;
            }
        } finally {
            if (res != null) {
                res.close();
            }
            client.close();
        }
    }

    public static void requestParamTest() throws Exception {
        String json0101 = "{\"name\":\"1111\"}";
        String result0101 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestName", json0101);//能调到服务端，收不到参数
        System.out.println(result0101);
        String result0102 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestName?name=123456", json0101);//能调到服务端，收到name参数
        System.out.println(result0102);

        String json0201 = "{\"menuId\":\"1111\",\"menuName\":\"menuName-01\",\"menuUrl\":\"menuUrl-01\"}";
        String result0201 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestMenu?menuId=1111&menuName=menuName", json0201);//调不到服务端
        System.out.println(result0201);
        String result0202 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestMenu?menuId=1111", json0201);//能调到服务端，收到menuId参数
        System.out.println(result0202);
        String result0203 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestMenu", json0201);//能调到服务端，收不到参数
        System.out.println(result0203);

        String json0301 = "{\"name\":\"1111\"}";
        String result0301 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestParamName", json0301);//调不到服务端
        System.out.println(result0301);
        String result0302 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestParamName?name=123456", json0301);//能调到服务端，收到name参数
        System.out.println(result0302);

        String json0401 = "{\"menuId\":\"1111\",\"menuName\":\"menuName-01\",\"menuUrl\":\"menuUrl-01\"}";
        String result0401 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestParamMenu?menuId=1111&menuName=menuName", json0401);//调不到服务端
        System.out.println(result0401);
        String result0402 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestParamMenu?menuId=1111", json0401);//调不到服务端
        System.out.println(result0402);
        String result0403 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestParamMenu", json0401);//调不到服务端
        System.out.println(result0403);

        String json0501 = "{\"name\":\"1111\"}";
        String result0501 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestBodyName", json0501);//能调到服务端，name参数收到 {"name":"1111"}
        System.out.println(result0501);
        String result0502 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestBodyName?name=123456", json0501);//能调到服务端，name参数收到 {"name":"1111"}
        System.out.println(result0502);

        String json0601 = "{\"menuId\":1111,\"menuName\":\"menuName-01\",\"menuUrl\":\"menuUrl-01\"}";
        String result0601 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestBodyMenu?menuId=1111&menuName=menuName", json0601);//调不到服务端
        System.out.println(result0601);
        String result0602 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestBodyMenu?menuId=1111", json0601);//调不到服务端
        System.out.println(result0602);
        String result0603 = sendPostRequestJSON("http://127.0.0.1:7095/param/requestBodyMenu", json0601);//调不到服务端
        System.out.println(result0603);
    }
}
