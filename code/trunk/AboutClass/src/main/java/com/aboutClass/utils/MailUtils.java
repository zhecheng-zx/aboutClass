package com.aboutClass.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * @author DengJie
 * @version 创建时间：2016年8月5日 类说明:
 */
public class MailUtils {

	/**
	 * 发送邮件
	 * 
	 * @param email
	 *            收件人邮箱
	 * @param title
	 *            邮件标题
	 * @param context
	 *            邮件内容
	 * @return boolean
	 */
	public static boolean sendEmail(String email, String title, String context) {
		boolean bool = false;
		try {
			sendAndCc(email, title, context);
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	public static void sendAndCc(String email, String title, String context) {
		try {
			String mailUser=PropetiesUtils.getKeyInfo("constant.properties", "mail.user").toString();
			String mailPassword=PropetiesUtils.getKeyInfo("constant.properties", "mail.password").toString();
			String mailPersonal=PropetiesUtils.getKeyInfo("constant.properties", "mail.personal").toString();
			// 1. 创建一封邮件
			final Properties props = new Properties();
			// 表示SMTP发送邮件，需要进行身份验证
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.163.com");
			// 2. From: 发件人
			props.put("mail.user",mailUser);
			// 访问SMTP服务时需要提供的密码
			props.put("mail.password", mailPassword);
			// 构建授权信息，用于进行SMTP进行身份验证
			Authenticator authenticator = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// 用户名、密码
					String userName = props.getProperty("mail.user");
					String password = props.getProperty("mail.password");
					return new PasswordAuthentication(userName, password);
				}
			};
			// 使用环境属性和授权信息，创建邮件会话
			Session mailSession = Session.getInstance(props, authenticator);
			// 创建邮件消息
			MimeMessage message = new MimeMessage(mailSession);
			// 设置发件人
			try {
				InternetAddress address = new InternetAddress(mailUser, mailPersonal,"utf-8");
				message.setFrom(address);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			// 3. To: 收件人
			InternetAddress to = new InternetAddress(email);
			message.setRecipient(RecipientType.TO, to);
//			 //   To: 增加收件人（可选）
//	        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("1354641556@qq.com", "IT中学生", "UTF-8"));
//	        //    Cc: 抄送（可选）
//	        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("1181720235@qq.com", "IT高中生", "UTF-8"));
//	        //    Bcc: 密送（可选）
//	        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("14675286@qq.com", "IT大学生", "UTF-8"));

			// 4. Subject: 邮件主题
			message.setSubject(title,"utf-8");

			// 5. Content: 邮件正文（可以使用html标签）
			message.setContent(context, "text/html;charset=UTF-8");
			// 6. 设置显示的发件时间
	        message.setSentDate(new Date());
			// 发送邮件
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		boolean send=MailUtils.sendEmail("1354641556@qq.com", "中奖信息", "恭喜您获得5000元消费基金！");
		System.out.println(send);
	}
}
