package org.practice.jpush;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.device.AliasDeviceListResult;
import cn.jpush.api.device.TagAliasResult;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.SMS;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * @author yoong
 *
 * @desc 极光推送官方文档 <br>
 *       https://docs.jiguang.cn/jpush/server/sdk/java_sdk/
 *
 * @date 2018年8月15日
 *
 */
public class JPushAPI {

	private static Log LOG = LogFactory.getLog(App.class);

	// chedai APP
	private static String MASTER_SECRET = "74711a56d3fec33a3b0fac38";
	private static String APP_KEY = "2de8b027cf38fca0af08e70c";

	// 极光Demo APP
	// private static String MASTER_SECRET = "9ee7247b000f33ba1aa75c08";
	// private static String APP_KEY = "0f3b7426368fe5e945eefefb";

	// 推送对象别名 dev_15706258110 dev_15158107051 dev_15729355611
	private static String alias = "dev_15729355611";
	private static String tag = "tag";
	// 消息常量
	private static String ALERT = "ALERT - 2018年8月15日15:39:35";
	private static String TITLE = "TITLE - 2018年8月15日15:39:42";
	private static String MSG_CONTENT = "MSG_CONTENT";

	/**
	 * 入口函数
	 */
	public static void main(String[] args) {
		// push();
		getDevice();
	}

	/**
	 * 推送样例
	 */
	public static void push() {
		JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
		PushPayload payload = buildPushObject_all_alias_alert();
		PushPayload payload2 = buildPushObject_ios_tagAnd_alertWithExtrasAndMessage();

		try {
			PushResult result = jpushClient.sendPush(payload2);
			if (result.isResultOK()) {
				System.out.println("push 推送消息成功！");
			} else {
				System.out.println("push 推送消息失败！");
			}
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			LOG.error("Connection error, should retry later", e);
			e.printStackTrace();
		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			LOG.error("Should review the error, and fix the request", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jpushClient.close();
	}

	/**
	 * 查询绑定某别名的设备有哪些
	 */
	public static void getDevice() {
		try {
			JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
			AliasDeviceListResult androidDevice = jpushClient.getAliasDeviceList(alias, "android");
			AliasDeviceListResult iosDevice = jpushClient.getAliasDeviceList(alias, "ios");
			System.out.println(androidDevice);
			System.out.println(iosDevice);

//			String REGISTRATION_ID1 = "1104a89792fe4490e68";
//			TagAliasResult result = jpushClient.getDeviceTagAlias(REGISTRATION_ID1);
//			System.out.println(result);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 构建推送对象：所有平台，所有设备，内容为 ALERT 的通知
	 * 
	 * @return
	 *
	 */
	public static PushPayload buildPushObject_all_all_alert() {
		return PushPayload.alertAll(ALERT);
	}

	/**
	 * 构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT
	 * 
	 * @return
	 *
	 */
	public static PushPayload buildPushObject_all_alias_alert() {
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(alias)).setNotification(Notification.alert(ALERT)).build();
	}

	/**
	 * 构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE
	 * 
	 * @return
	 *
	 */
	public static PushPayload buildPushObject_android_tag_alertWithTitle() {
		return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag(tag)).setNotification(Notification.android(ALERT, TITLE, null)).build();
	}

	/**
	 * 构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的交集，推送内容同时包括通知与消息 - 通知信息是
	 * ALERT，角标数字为 5，通知声音为 "happy"，并且附加字段 from = "JPush"；消息内容是 MSG_CONTENT。
	 * 
	 * @return
	 *
	 */
	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.alias(alias))
				.setNotification(
						Notification.newBuilder().addPlatformNotification(IosNotification.newBuilder().setAlert(ALERT).setBadge(5).setSound("happy").addExtra("from", "JPush").build()).build())
				.setMessage(Message.content(MSG_CONTENT)).setOptions(Options.newBuilder().setApnsProduction(true).build()).build();
	}

	/**
	 * 构建推送对象：平台是 Andorid 与 iOS，推送目标是 （"tag1" 与 "tag2" 的并集）交（"alias1" 与 "alias2"
	 * 的并集），推送内容是 - 内容为 MSG_CONTENT 的消息，并且附加字段 from = JPush。
	 * 
	 * @return
	 *
	 */
	public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
		return PushPayload.newBuilder().setPlatform(Platform.android_ios())
				.setAudience(Audience.newBuilder().addAudienceTarget(AudienceTarget.tag("tag1", "tag2")).addAudienceTarget(AudienceTarget.alias("alias1", "alias2")).build())
				.setMessage(Message.newBuilder().setMsgContent(MSG_CONTENT).addExtra("from", "JPush").build()).build();
	}

	/**
	 * 构建推送对象：推送内容包含SMS信息
	 *
	 */
	public static void testSendWithSMS() {
		String masterSecret = "";
		String appKey = "";
		JPushClient jpushClient = new JPushClient(masterSecret, appKey);
		try {
			SMS sms = SMS.content("Test SMS", 10);
			PushResult result = jpushClient.sendAndroidMessageWithAlias("Test SMS", "test sms", sms, "alias1");
			LOG.info("Got result - " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}
}
