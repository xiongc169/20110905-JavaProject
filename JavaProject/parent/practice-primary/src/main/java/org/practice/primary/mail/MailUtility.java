package org.practice.primary.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @description MailUtility.java
 * @author chaoxiong
 * @date 2016年4月27日 上午10:15:58
 */
public class MailUtility {

	/**
	 * @description TODO
	 * @param args
	 * @return void
	 * @author chaoxiong
	 * @date 2016年4月27日 上午10:15:58
	 */
	public static void main(String[] args) throws Exception {
		try {
			sendEmailByItsm();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @description itsm系统发送邮件demo
	 * @throws Exception
	 * @return void
	 * @author chaoxiong
	 * @date 2016年4月27日 下午5:24:22
	 */
	public static void sendEmailByItsm() throws Exception {
		String hostName = "mail.hundsun.com";
		final String mailUsername = "xiongchao17860";// 用户名
		final String mailPassword = "tgb$$1112";// 密码 需要向信息中心申请
		// MailSend mail = new MailSend();
		Properties props = System.getProperties();
		props.put("mail.smtp.host", hostName);
		props.put("mail.smtp.auth", "true");// 设置smtp认证 true/false

		// 认证信息
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailUsername, mailPassword);
			}
		});
		session.setDebug(true);
		MimeMessage mimeMsg = new MimeMessage(session);
		mimeMsg.setSubject("测试邮件主题", "utf-8");// 设置邮件主题
		mimeMsg.setText("这是一封测试邮件，邮件组的小伙伴收到没？", "utf-8");// 设置邮件内容

		// 收件人
		List<String> destMailList = new ArrayList<String>();
		destMailList.add("xiongc169@163.com");
		Address addresses_dest[] = new Address[destMailList.size()];
		for (int i = 0; i < destMailList.size(); i++) {
			addresses_dest[i] = new InternetAddress(destMailList.get(i));
		}
		mimeMsg.setRecipients(Message.RecipientType.TO, addresses_dest);

		// 抄送人
		String copyto = "942131083@qq.com";
		mimeMsg.setRecipients(Message.RecipientType.CC, (Address[]) InternetAddress.parse(copyto));

		// 密件发送
		String secretto = "beartony1991@sina.com";
		mimeMsg.setRecipients(Message.RecipientType.BCC, (Address[]) InternetAddress.parse(copyto));

		// 发件人 邮箱
		mimeMsg.setFrom(new InternetAddress("xiongchao17860@hundsun.com"));
		mimeMsg.setHeader("Content-Type", "text/html; charset=\"utf-8\"");
		mimeMsg.setHeader("Content-Transfer-Encoding", "7bit");
		Transport.send(mimeMsg);
	}

	/**
	 * @description TODO
	 * 
	 * @return void
	 * @author chaoxiong
	 * @date 2016年4月27日 下午5:25:24
	 */
	public static void sendEmail() {

	}

}
