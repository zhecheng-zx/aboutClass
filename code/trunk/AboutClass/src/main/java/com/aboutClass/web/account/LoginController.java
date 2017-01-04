package com.aboutClass.web.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.aboutClass.model.aboutClass.TUser;
import com.aboutClass.web.AbstractController;
/**
 * @author zx
 * @version 2017年1月1日20:30:43
 * 说明：登录模块
 * */
@Controller
public class LoginController extends AbstractController{
	private Logger logger= LoggerFactory.getLogger(LoginController.class);
	/**
	 * @author zx
	 * @version 2017年1月1日20:32:51
	 * 登录页面 
	 *  
	 * */
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	public String Login(HttpServletRequest request,HttpServletResponse response){
		if(SecurityUtils.getSubject().getSession()!=null){
			SecurityUtils.getSubject().logout();
		}
		logger.info("login");
		return "account/login";
	}
}
