package com.aboutClass.web.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aboutClass.web.AbstractController;
import com.aboutClass.service.system.UserPackageService;
import com.aboutClass.service.user.UsersLogsService;
/**
 * 测试的Controller.
 * 
 *@author zx
 */
@Controller
@RequestMapping(value = "/test")
public class Test extends AbstractController {
	@Autowired
	private UserPackageService userPackageService;
	@Autowired
	private UsersLogsService usersLogsService;
	/**
	 * 未登录页跳转
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="test1",method = { RequestMethod.POST, RequestMethod.GET })
	public String panoramicNotLog( Model model,HttpServletRequest request,HttpServletResponse response) {
		return "test/test";
	}
}
