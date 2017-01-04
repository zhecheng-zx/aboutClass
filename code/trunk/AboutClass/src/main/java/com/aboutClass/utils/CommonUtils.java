package com.aboutClass.utils;

/** 
* @author DengJie 
* @version 创建时间：2016年10月21日
* 类说明:公共工具类
*/
public class CommonUtils {
	public static final int HASH_INTERATIONS = 1024;
	/**
	 * 获取MD5加密密码
	 * @param salt 用户salt
	 * @param password 用户输入密码
	 * @return 
	 */
	public static String MD5Password(String salt, String password) {
		byte[] hashPassword = Digests.sha1(password.getBytes(), Encodes.decodeHex(salt),HASH_INTERATIONS);
		password = Encodes.encodeHex(hashPassword);
		return password;
	}
}
