package org.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.practice.jpush.App;
import org.practice.jpush.domain.JPushParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yoong
 *
 * @desc PushController.java
 *
 * @date 2018年8月16日
 */
@Controller
@RequestMapping("/push")
public class PushController {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public PushController() {
        System.out.println("PushController.PushController() " + format.format(new Date()));
    }

    /**
     * http://10.10.16.133:8080/push/login
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String msg = "PushController.login() " + format.format(new Date());
        System.out.println(msg);
        return msg;
    }

    /**
     * http://10.10.16.133:8080/push/pushMessage?alias=dev_15706258110&msgId=18&creditId=20287159
     */
    @ResponseBody
    @RequestMapping("/pushMessage")
    public String pushMessage(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "alias", required = false) String alias,
                              @RequestParam(value = "msgId", required = false) String msgId,
                              @RequestParam(value = "creditId", required = false) String creditId) {
        String now = format.format(new Date());
        try {
            Map<String, String> extras = new HashMap<>();
            extras.put("id", "msgId");
            extras.put("businessObjectId", "creditId");
            extras.put("flowType", "CREDIT_FLOW");
            extras.put("nodeKey", "CREDIT_ENTER");
            String uriActivity = "com.liancheng.chedai.base.TransferActivity";

            JPushParam jpushParam = new JPushParam(alias, "征信信息", now + "客户【钟梦菲】杭州建行征信结果已反馈", uriActivity, 0, extras);
            //boolean result = App.pushMessage(jpushParam);
            return "Push Success  " + now;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Push Failure  " + now;
        }
    }
}
