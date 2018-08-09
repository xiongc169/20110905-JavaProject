package org.practice.jpush;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
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
 * @desc 极光推送(chedaiApp) <br>
 *       https://docs.jiguang.cn/jpush/server/sdk/java_sdk
 *
 * @date 2018年8月9日
 *
 */
public class App {

	private static Log LOG = LogFactory.getLog(App.class);
	private static String MASTER_SECRET = "";
	private static String APP_KEY = "";
	private static String ALERT = "ALERT";
	private static String TITLE = "TITLE";
	private static String MSG_CONTENT = "MSG_CONTENT";

	/**
	 * 入口函数
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public static void push() {
		JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
		PushPayload payload = buildPushObject_all_all_alert();

		try {
			PushResult result = jpushClient.sendPush(payload);
			LOG.info("Got result - " + result);

		} catch (APIConnectionException e) {
			// Connection error, should retry later
			LOG.error("Connection error, should retry later", e);

		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			LOG.error("Should review the error, and fix the request", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
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
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias("alias1")).setNotification(Notification.alert(ALERT)).build();
	}

	/**
	 * 构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE
	 * 
	 * @return
	 *
	 */
	public static PushPayload buildPushObject_android_tag_alertWithTitle() {
		return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag("tag1")).setNotification(Notification.android(ALERT, TITLE, null)).build();
	}

	/**
	 * 构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的交集，推送内容同时包括通知与消息 - 通知信息是
	 * ALERT，角标数字为 5，通知声音为 "happy"，并且附加字段 from = "JPush"；消息内容是 MSG_CONTENT。
	 * 
	 * @return
	 *
	 */
	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.tag_and("tag1", "tag_all"))
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
