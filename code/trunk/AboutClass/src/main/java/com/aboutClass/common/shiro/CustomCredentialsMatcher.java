package com.aboutClass.common.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.aboutClass.model.aboutClass.TUser;
import com.aboutClass.service.user.UserService;
import com.aboutClass.utils.Digests;
import com.aboutClass.utils.Encodes;

/**
 * 自定义 密码验证类
 * 
 * @author dj
 *
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	public static final int HASH_INTERATIONS = 1024;
	private UserService userService;
	public CustomCredentialsMatcher(UserService userService){
		this.userService=userService;
	}
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		Object tokenCredentials = encrypt(token);
		Object accountCredentials = getCredentials(info);
		// 将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
		return equals(tokenCredentials, accountCredentials);
	}

	// 将传进来密码加密方法
	private String encrypt(UsernamePasswordToken token) {
		String pass = String.valueOf(token.getPassword());
		if (pass.length() >= 40) {
			return pass;
		} else {
			TUser user = userService.findOne(token.getUsername());
			byte[] salt = Encodes.decodeHex(user.getSalt());
			byte[] hashPassword = Digests.sha1(pass.getBytes(), salt, HASH_INTERATIONS);
			pass = Encodes.encodeHex(hashPassword);
		}
		return pass;
	}
}
