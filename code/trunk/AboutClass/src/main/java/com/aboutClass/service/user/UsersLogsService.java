package com.aboutClass.service.user;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aboutClass.model.aboutClass.TUsersLogs;
import com.aboutClass.repository.UsersLogsDao;


//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class UsersLogsService {

	private static Logger logger = LoggerFactory.getLogger(UsersLogsService.class);
	@Autowired
	private UsersLogsDao usersLogsDao;
	
	/**
	 * 
	 * @param user_id   用户ID
	 * @param name      用户名
	 * @param type      操作模块类型
	 * @param content   参数
	 * @param ip        IP
	 * @param classify  类
	 * @param fun       方法
	 */
	public void save(Long user_id,String name,String type,String content,String ip,String classify,String fun) {
		TUsersLogs entity = new TUsersLogs();
		entity.setUserId(user_id);
		entity.setName(name);
		entity.setType(type);
		entity.setContent(content);
		entity.setIp(ip);
		entity.setClassify(classify);
		entity.setFun(fun);
		entity.setTime(new Date());
		usersLogsDao.save(entity);
	}
}
