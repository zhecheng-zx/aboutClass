package com.aboutClass.utils;

import org.apache.shiro.SecurityUtils;

import com.aboutClass.common.shiro.ShiroUser;
import com.aboutClass.model.aboutClass.TUser;
import com.aboutClass.model.aboutClass.TUserPackage;

/** 
* @author DengJie 
* @version 创建时间：2016年11月30日
* 类说明:
*/
public class shiroUtils {
	/**
	 * 更新Shiro中用户信息.
	 */
	public static void updateShiroUser(TUser user) {
		ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		shiroUser.phone = user.getPhone();
		shiroUser.name = user.getName();
		shiroUser.user=user;
		shiroUser.province=user.getProvince();
		shiroUser.city=user.getCity();
		shiroUser.country=user.getCountry();
	}
	/**
	 * 更新Shiro中用户套餐信息.
	 */
	public static void updateShiroUPackage(TUserPackage upackage) {
		ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		shiroUser.uPackage=upackage;
	}
}
