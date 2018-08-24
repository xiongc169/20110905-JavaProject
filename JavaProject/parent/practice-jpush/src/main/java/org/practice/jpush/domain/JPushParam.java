package org.practice.jpush.domain;

import java.util.Map;

/**
 * 极光推送的参数类
 */
public class JPushParam {

	/**
	 * 推送对象别名
	 */
	private String alias;

	/**
	 * 通知标题
	 */
	private String title;

	/**
	 * 通知内容
	 */
	private String content;

	/**
	 * uri_activity，解决 华为机 点不开推送通知的属性配置
	 */
	private String uriActivity;

	/**
	 * 角标
	 */
	private int badge;

	/**
	 * 通知的附加信息
	 */
	private Map<String, String> extras;

	public JPushParam() {
	}

	/**
	 * 构造函数
	 *
	 * @param alias 推送对象别名
	 * @param title 通知标题
	 * @param content 通知内容
	 * @param uriActivity uri_activity，解决 华为机 点不开推送通知的属性配置
	 * @param badge 角标
	 * @param extras 通知的附加信息
	 */
	public JPushParam(String alias, String title, String content, String uriActivity, int badge, Map<String, String> extras) {
		this.alias = alias;
		this.title = title;
		this.content = content;
		this.uriActivity = uriActivity;
		this.badge = badge;
		this.extras = extras;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUriActivity() {
		return uriActivity;
	}

	public void setUriActivity(String uriActivity) {
		this.uriActivity = uriActivity;
	}

	public int getBadge() {
		return badge;
	}

	public void setBadge(int badge) {
		this.badge = badge;
	}

	public Map<String, String> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, String> extras) {
		this.extras = extras;
	}
}
