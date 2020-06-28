package org.practice.primary.book02.chap03;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @Desc 电子合同-查询合同模板
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020年5月26日
 * <p>
 * @Version 1.0
 */
public class EContractUtils {

    private static final String CHAR_SET = "UTF-8";
    private static final String CONTENT_TYPE = "application/json";
    private static final int CONNECT_TIMEOUT = 30000;
    private static final int CONNECTION_REQUEST_TIMEOUT = 5000;
    private static final int SOCKET_TIMEOUT = 60000;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            String json = "{\"appId\":\"ftcs-test\",\"body\":\"BYprHoNf7CPKJ32xhe6BUoC+QUJkGnKwU46Wp8z4VsaWg/2Sixam5fVMZ41Q/wKPB5AH8ZbPXwtIbHJUNNhGYiG3GG76z4MCOlvR8FmzrRgzFRstOEK2C5LQ8/uZNKwUGx2pIwaSOv3xuKjnzgwZ5WmFD7MUqhRN4I+jRc2IsDQ=\",\"sequenceId\":\"2020-05-26 16:41:46\",\"sign\":\"4478c43f955a752a8836ae4282b06752\"}";
            String result = EContractUtils.sendPostRequestJSON("http://192.168.27.21:9853/api/v1/getTemplateList", json);
            System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String sendPostRequestJSON(String requestUrl, String json) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse res = null;
        try {
            //        logger.info(" ==> 传入的json: {}", json.toJSONString());
            HttpPost post = new HttpPost(requestUrl);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT).build();
            post.setConfig(requestConfig);
            // 将JSON进行UTF-8编码,以便传输中文
            //logger.info("request time:{}, url:{}, json:{}", System.currentTimeMillis(), requestUrl, json);
            StringEntity string = new StringEntity(json, CHAR_SET);
            string.setContentEncoding(CHAR_SET);
            string.setContentType(CONTENT_TYPE);
            post.setEntity(string);
            res = client.execute(post);
            //logger.info("res.getStatusLine():{}", res.getStatusLine().getStatusCode());
            if (res.getStatusLine().getStatusCode() == 200) {
                String result = EntityUtils.toString(res.getEntity());
                //logger.info("response json:{}", result);
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
}
