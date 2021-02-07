package com.yoong.jpush;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosAlert;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.yoong.jpush.domain.JPushParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 极光推送(chedaiApp)
 * https://docs.jiguang.cn/jpush/server/sdk/java_sdk
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月9日
 * <p>
 * @Version 1.0
 */
public class App {

    private static Log LOG = LogFactory.getLog(App.class);

    // chedai APP
    private static String MASTER_SECRET = "74711a56d3fec33a3b0fac38";
    private static String APP_KEY = "2de8b027cf38fca0af08e70c";

    // 极光Demo APP
    // private static String MASTER_SECRET = "9ee7247b000f33ba1aa75c08";
    // private static String APP_KEY = "0f3b7426368fe5e945eefefb";

    // 推送对象别名 dev_15706258110 dev_15158107051 dev_15068129031 test_18700000002 product_15158107054 product_13588756278 product_15215740001
    private static String alias = "product_15215740001";
    private static String tag = "tag";
    // 消息常量
    private static String title = "征信信息";
    private static String content = "客户【钟梦菲】杭州建行征信结果已反馈，请查收";
    private static String uriActivity = "com.liancheng.chedai.base.TransferActivity";
    private static int badge = 0;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        Map<String, String> extras = new HashMap<>();
        extras.put("id", "10");
        extras.put("businessObjectId", "20287159");
        extras.put("flowType", "CREDIT_FLOW");
        extras.put("nodeKey", "CREDIT_ENTER");
        JPushParam jpushParam = new JPushParam(alias, title, content, uriActivity, badge + 1, extras);

        if (args.length > 2) {
            jpushParam = new JPushParam(args[0], args[1], args[2], uriActivity, badge + 1, extras);
            pushMessage(jpushParam);
        } else {
            pushMessage(jpushParam);
        }

        // testSendIosAlert("dev_15706258110", "征信信息", "testSendIosAlert-2018年8月15日15:12:37", new HashMap<String, String>());
    }

    /**
     * 消息推送接口
     */
    public static boolean pushMessage(JPushParam jpushParam) {
        JPushClient jpushClient = null;
        try {
            jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
            PushPayload payload = buildAndroidAndIOSByAliasWithMsgExtras(jpushParam);
            PushResult result = jpushClient.sendPush(payload);
            if (result.isResultOK()) {
                System.out.println("推送消息成功！");
            } else {
                System.out.println("推送消息失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jpushClient != null) {
                try {
                    jpushClient.close();
                } catch (Exception e) {
                }
            }
        }
        return true;
    }

    /**
     * 构建推送对象：平台是 Android\IOS，推送目标是别名为 "alias"，内容是 msgTitle，并且标题为 msgContent
     */
    public static PushPayload buildAndroidAndIOSByAliasWithMsgExtras(String alias, String msgTitle, String msgContent, Map<String, String> extras) {
        IosAlert iosAlert = IosAlert.newBuilder().setTitleAndBody(msgTitle, "", msgContent).build();
        return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder().addPlatformNotification(IosNotification.newBuilder().setAlert(iosAlert).addExtras(extras).build())
                        .addPlatformNotification(AndroidNotification.newBuilder().setTitle(msgTitle).setAlert(msgContent).addExtras(extras).build()).build())
                .build();
    }

    /**
     * 构建推送对象：平台是 Android\IOS，推送目标是别名为 "alias"，内容是 msgContent，并且标题为 msgTitle
     */
    public static PushPayload buildAndroidAndIOSByAliasWithMsgExtras(JPushParam jpushParam) {
        IosAlert iosAlert = IosAlert.newBuilder().setTitleAndBody(jpushParam.getTitle(), "", jpushParam.getContent()).build();
        return PushPayload.newBuilder().setPlatform(Platform.all())
                .setAudience(
                        Audience.alias(jpushParam.getAlias()))
                .setNotification(
                        Notification.newBuilder().addPlatformNotification(IosNotification.newBuilder().setAlert(iosAlert).setBadge(jpushParam.getBadge()).addExtras(jpushParam.getExtras()).build())
                                .addPlatformNotification(AndroidNotification.newBuilder().setTitle(jpushParam.getTitle()).setAlert(jpushParam.getContent()).setUriActivity(jpushParam.getUriActivity())
                                        .addExtras(jpushParam.getExtras()).build())
                                .build())
                .setOptions(Options.newBuilder().setApnsProduction(true).build()).build();
    }

    /**
     * iOS推送测试
     * https://community.jiguang.cn/t/ios-title-subtitle/10505/4
     */
    public static void testSendIosAlert(String alias, String msgTitle, String msgContent, Map<String, String> extras) {
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);

        IosAlert alert = IosAlert.newBuilder().setTitleAndBody(msgTitle, "subtitle", msgContent).setActionLocKey("PLAY").build();
        try {
            PushResult result = jpushClient.sendIosNotificationWithAlias(alert, new HashMap<String, String>(), alias);
            if (result.isResultOK()) {
                System.out.println("testSendIosAlert 推送消息成功！");
            } else {
                System.out.println("testSendIosAlert 推送消息失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
