package org.practice.activemq.activemq1;

import javax.jms.*;
import java.text.SimpleDateFormat;

/**
 * @author 20180112002
 * <br/>
 * @desc http://boy00fly.iteye.com/blog/1103586
 * <br/>
 * @date 2018年7月25日
 */
public class P2PMessageListener implements MessageListener {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage txtMsg = (TextMessage) message;
            System.out.println("接收：" + txtMsg.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
