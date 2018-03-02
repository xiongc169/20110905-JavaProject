package org.practice.thread;

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

public class SendEmailThread implements Runnable {

	private List<String> receiver;

	public SendEmailThread(List<String> receiver) {
		this.receiver = receiver;
	}

	public void run() {

		try {
			// String hostName = "mail.hundsun.com";
			// final String mailUsername = "xiongchao17860";// 用户名
			// final String mailPassword = "qaz$$1112";// 密码 需要向信息中心申请
			// // MailSend mail = new MailSend();
			// Properties props = System.getProperties();
			// props.put("mail.smtp.host", hostName);
			// props.put("mail.smtp.auth", "true");// 设置smtp认证 true/false

			String hostName = "smtp.sina.com";
			final String mailUsername = "beartony1991";// 用户名
			final String mailPassword = "tony&&3045184";// 密码 需要向信息中心申请
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
			session.setDebug(false);
			MimeMessage mimeMsg = new MimeMessage(session);
			mimeMsg.setSubject("测试邮件主题", "utf-8");// 设置邮件主题
			mimeMsg.setText("这是一封测试邮件，邮件组的小伙伴收到没？", "utf-8");// 设置邮件内容

			// 收件人
			Address addresses_dest[] = new Address[receiver.size()];
			for (int i = 0; i < receiver.size(); i++) {
				addresses_dest[i] = new InternetAddress(receiver.get(i));
			}
			mimeMsg.setRecipients(Message.RecipientType.TO, addresses_dest);

			// 发件人 邮箱
			mimeMsg.setFrom(new InternetAddress("beartony1991@sina.com"));
			mimeMsg.setHeader("Content-Type", "text/html; charset=\"utf-8\"");
			mimeMsg.setHeader("Content-Transfer-Encoding", "7bit");
			Transport.send(mimeMsg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
