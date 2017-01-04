package com.aboutClass.common.shiro;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aboutClass.model.aboutClass.TUser;
import com.aboutClass.model.aboutClass.TUserPackage;
import com.aboutClass.service.system.UserPackageService;
import com.aboutClass.service.user.UserService;
import com.aboutClass.utils.Encodes;

/**
 * Subject验证的过程可以有效地划分分以下三个步骤： 1.收集Subject提交的身份和证明； 2.向Authenticating提交身份和证明；
 * 3.如果提交的内容正确，允许访问，否则重新尝试验证或阻止访问
 * Realm：可以有1个或多个Realm，可以认为是安全实体数据源，即用于获取安全实体的；
 * 可以是JDBC实现，也可以是LDAP实现，或者内存实现等等；由用户提供；
 * 注意：Shiro不知道你的用户/权限存储在哪及以何种格式存储；所以我们一般在应用中都需要实现自己的Realm
 * @author dj
 * 
 */
@Component("shiroDbRealm")
public class ShiroDbRealm extends AuthorizingRealm {
	private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
	
	private UserService userService;
	private UserPackageService userPackageService;
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {

		// 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
		// (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			doClearCache(principalCollection);
			SecurityUtils.getSubject().logout();
			return null;
		}

		TUser psu = (TUser) principalCollection.getPrimaryPrincipal();
		Long userId = psu.getId();
		if (userId == null) {
			return null;
		}
		// 添加角色及权限信息
		SimpleAuthorizationInfo sazi = new SimpleAuthorizationInfo();
		try {
			//sazi.addRoles(pusSysUserDao.getRolesAsString(userId)); // 获取当前用户所有的角色,
			//用于依据角色判断权限的shiro过滤器
			//Set<String> sp = pusSysUserDao.getPermissionsAsString(userId); // 获取当前用户的所有权限,
			//sazi.addStringPermissions(sp); 
			// 权限就是url,一个url的集合
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return sazi;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 调用业务方法
		TUser user = null;
		TUserPackage userPackage = null;
		String userName = upToken.getUsername();
		try {
			user = userService.findOne(userName);
			userPackage = userPackageService.findOneByUserId(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		if (user != null) {
			byte[] salt = Encodes.decodeHex(user.getSalt());
			AuthenticationInfo authinfo = new SimpleAuthenticationInfo(new ShiroUser(user,userPackage),user.getPassword(),
					ByteSource.Util.bytes(salt), getName());
			return authinfo;
		}
		// 认证没有通过
		return null;
	}

	/**
	 * 设定Password校验.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		setCredentialsMatcher(new CustomCredentialsMatcher(userService));
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUserPackageService(UserPackageService userPackageService) {
		this.userPackageService = userPackageService;
	}
	
}
