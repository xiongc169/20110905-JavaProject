package org.practice.jpush;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosAlert;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * @author yoong
 *
 * @desc 极光推送(chedaiApp) <br>
 *       https://docs.jiguang.cn/jpush/server/sdk/java_sdk
 *
 * @date 2018年8月9日
 *
 */
public class App {

	private static Log LOG = LogFactory.getLog(App.class);

	// chedai APP
	private static String MASTER_SECRET = "74711a56d3fec33a3b0fac38";
	private static String APP_KEY = "2de8b027cf38fca0af08e70c";

	// 极光Demo APP
	// private static String MASTER_SECRET = "9ee7247b000f33ba1aa75c08";
	// private static String APP_KEY = "0f3b7426368fe5e945eefefb";

	// 推送对象别名 dev_15706258110 dev_15158107051
	private static String alias = "dev_15706258110";
	private static String tag = "tag";
	// 消息常量
	private static String ALERT = "ALERT - 2018年8月15日15:39:35";
	private static String TITLE = "TITLE - 2018年8月15日15:39:42";
	private static String MSG_CONTENT = "MSG_CONTENT";

	/**
	 * 入口函数
	 */
	public static void main(String[] args) {
		if (args.length > 2) {
			pushMessage(args[0], args[1], args[2]);
		} else {
			pushMessage("dev_15706258110", "征信信息", "客户【王建菲】杭州建行征信结果已反馈，请查收-2018年8月17日11:52:10");
		}

		// testSendIosAlert("dev_15706258110", "征信信息", "testSendIosAlert -
		// 2018年8月15日15:12:37", new HashMap<String, String>());
	}

	/**
	 * 消息推送接口
	 *
	 * @param alias 推送对象别名
	 * @param title 通知标题
	 * @param content 通知内容
	 * @param flowType 消息的业务类型
	 * @param nodeKey 消息的节点类型
	 * @param id 消息跳转需要的id
	 */
	public static boolean pushMessage(String alias, String msgTitle, String msgContent) {
		JPushClient jpushClient = null;

		Map<String, String> extras = new HashMap<>();
		extras.put("flowType", "CREDIT_FLOW");
		extras.put("nodeKey", "CREDIT_ENTER");
		extras.put("id", "20287153");
		try {
			jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
			PushPayload payload = buildAndroidAndIOSByAliasWithMsgExtras(alias, msgTitle, msgContent, extras);
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
	 *
	 * @return
	 */
	public static PushPayload buildAndroidAndIOSByAliasWithMsgExtras(String alias, String msgTitle, String msgContent, Map<String, String> extras) {
		IosAlert iosAlert = IosAlert.newBuilder().setTitleAndBody(msgTitle, "", msgContent).build();
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(alias))
				.setNotification(Notification.newBuilder().addPlatformNotification(IosNotification.newBuilder().setAlert(iosAlert).addExtras(extras).build())
						.addPlatformNotification(AndroidNotification.newBuilder().setTitle(msgTitle).setAlert(msgContent).addExtras(extras).build()).build())
				.build();
	}

	/**
	 * iOS推送测试<br>
	 * https://community.jiguang.cn/t/ios-title-subtitle/10505/4
	 *
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
