package com.aboutClass.utils;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MD5加密,校验token工具类
 */
public class MD5Utils {
	
	private static final Logger log = LoggerFactory.getLogger(MD5Utils.class);
	
	/*** 
     * MD5加密 生成32位md5码
     * @param 待加密字符串
     * @return 返回32位md5码
     */
    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
        	log.error("md5Encode error.", e);
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
	 /**
	  * MD5加密
	  * @param s
	  * @return
	  */
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 生成Token
	 * @return
	 */
	public final static String generateToken(String tokenKey, long currentTime) {
		// 获取 10 为毫秒值
		String keys = new String(tokenKey + currentTime + tokenKey);
		String token = MD5(keys);
		return token;
	}
	
	/**
	 * 验证token是否有效
	 * @param call 客户端请求时生成token的时间, 请求时间10位秒值
	 * @param token 客户端请求时生成的token
	 * @return
	 */
	public final static boolean verificationToken(long call, String token, long tokenLiveTime) {
		long currentTime = System.currentTimeMillis() / 1000;
		boolean flag = false;
		if (call <= currentTime && call >= (currentTime - tokenLiveTime)) {
			String newToken = generateToken(token, call);
			// 判断客户端生成的token和服务端生成的token是否一致
			if (newToken.equalsIgnoreCase(token)) {
				flag = true;
			} else {
				log.info("MD5Utils.verificationToken newToken :" + newToken);
				log.info("MD5Utils.verificationToken token :" + token);
				log.info("MD5Utils.verificationToken currentTime:" + currentTime);
				log.info("MD5Utils.verificationToken call:" + call);
			}
		} else {
			log.info("MD5Utils.verificationToken currentTime false: " + currentTime);
			log.info("MD5Utils.verificationToken call false: " + call);
			// 如果请求时间比服务器的时间大, 那么直接返回true
			if (call > currentTime) {
				flag = true;
				log.info("MD5Utils.verificationToken call gt currentTime return true.");
			}
		}
		return flag;
	}
	
	// 测试主函数
	public static void main(String args[]) {
		String key = "zkdj_yuQing";
		long a = System.currentTimeMillis() / 1000;
		System.out.println(a);

		a = 1448346989;
		String s1 = new String(key + a + key);
		System.out.println("MD5:" + MD5(s1));

		System.out.println(generateToken(key, 1448352567));
	}
}
