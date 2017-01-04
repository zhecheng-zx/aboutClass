package com.aboutClass.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
* @author DengJie 
* @version 创建时间：2016年8月5日
* 类说明:
*/
public class SMSUtils {
	private static Logger logger = LoggerFactory.getLogger(SMSUtils.class);
	
	/**
	 * 短信发送信息
	 * @param code 验证码
	 * @return String
	 */
	public static String getContent(String code) {
		String SMS_CONTENT=PropetiesUtils.getKeyInfo("constant.properties", "SMS_CONTENT").toString();
		String content = MessageFormat.format(SMS_CONTENT, code);
		return content;
	}
	/**
	 * 生成短信验证码
	 * @return code
	 */
	public static String getCode() {
		int msgCode = (int) (Math.random() * 9000) + 1000;
		return String.valueOf(msgCode);
	}
		/**
		 * 发送短信
		 * @param phone 短信接收人
		 * @param code 验证码
		 * @return boolean true:成功;false:失败
		 */
		public static boolean sendMessage(String phone, String code) {
			String content=SMSUtils.getContent(code);
			return sendSMS(phone, content);
		}
		/**
		 * 发送短信
		 * @param phone 短信接收人
		 * @param content 短信内容
		 * @return boolean true:成功;false:失败
		 */
		public static boolean sendSMS(String phone, String content) {
		
		HttpURLConnection urlConnection = null;
		BufferedReader reader = null;
		String result;
		try {
			String smsUrl =getSMSAccessAddress(phone);
			smsUrl = smsUrl + java.net.URLEncoder.encode(content, "UTF-8");
			URL url = new URL(smsUrl);
			urlConnection = (HttpURLConnection) url.openConnection();
			reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			// 读取返回值，进行判断
			while ((result = reader.readLine()) != null) {
				if ("0".equals(result)) {
					logger.error("短信发送成功");
					return true;
				} else{
					if ("-1".equals(result)) {
						logger.error("参数不全");
					} else if ("-2".equals(result)) {
						logger.error("服务器空间不支持,请确认支持curl或者fsocket，联系您的空间商解决或者更换空间！");
					} else if ("30".equals(result)) {
						logger.error("密码错误");
					} else if ("40".equals(result)) {
						logger.error("账号不存在");
					} else if ("41".equals(result)) {
						logger.error("余额不足");
					} else if ("42".equals(result)) {
						logger.error("帐户已过期");
					} else if ("43".equals(result)) {
						logger.error("IP地址限制");
					} else if ("50".equals(result)) {
						logger.error("内容含有敏感词");
					} else if ("100".equals(result)) {
						logger.error("短信平台连接失败");
					}
					return false;
				} 
			}
		} catch (Exception e) {
			logger.error("phone:【" + phone + "】 get Verification Code error", e);
			e.printStackTrace();
		} finally {
			try {
				if (null != reader) {
					reader.close();
				}
				if (null != urlConnection) {
					urlConnection.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * 短信宝发送注册短信URL
	 * 
	 * @param phone
	 * @param msgCode
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	public static String getSMSAccessAddress(String phone) throws UnsupportedEncodingException {
		String SMS_URL=PropetiesUtils.getKeyInfo("constant.properties", "SMS_URL").toString();
		String SMS_USER=PropetiesUtils.getKeyInfo("constant.properties", "SMS_USER").toString();
		String SMS_PASSWORD=PropetiesUtils.getKeyInfo("constant.properties", "SMS_PASSWORD").toString();
		String url = SMS_URL + "/sms?u=" + SMS_USER+ "&p=" + SMS_PASSWORD + "&m=" + phone + "&c=";
		return url;
	}
	public static void main(String[] args) {
		String phone="18610506830";
		String code = SMSUtils.getCode();
		boolean send = SMSUtils.sendMessage(phone, code);
		if(send){
			logger.info("短信发送成功！");
		}
	}
}
