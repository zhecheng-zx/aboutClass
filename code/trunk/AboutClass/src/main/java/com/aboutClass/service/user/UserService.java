package com.aboutClass.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aboutClass.model.aboutClass.TUser;
import com.aboutClass.repository.UserRepository;
import com.aboutClass.utils.DynamicSpecifications;
import com.aboutClass.utils.SearchFilter;
import com.aboutClass.utils.SearchFilter.Operator;

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * 根据手机号获取用户信息
	 * 
	 * @param phone
	 * @return
	 */
	public TUser findUserByPhone(String phone) {
		return userRepository.findUserByPhone(phone);
	}
	
	public TUser findOne(Long id) {
		return userRepository.findOne(id);
	}
	public TUser findOne(String account){
		Map<String, SearchFilter> filters = new HashMap<String, SearchFilter>();
		filters.put("phone", new SearchFilter("phone", Operator.EQ, account));
		Specification<TUser> spec = DynamicSpecifications.bySearchFilter(filters.values(), TUser.class);
		return userRepository.findOne(spec);
	}
	
	public void updateUser(TUser user) {
		userRepository.save(user);
	}
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<TUser> getTUsersList() {
		Map<String, SearchFilter> filters = new HashMap<String, SearchFilter>();
		Specification<TUser> spec = DynamicSpecifications.bySearchFilter(filters.values(), TUser.class);
		return userRepository.findAll(spec, new Sort(Direction.DESC, "id"));
	}
	/**
	 * 获取有效用户（未到期，客户等级不为0，注册完善step：2）
	 */
	public List<TUser> getOnTUsersList(){
		Map<String, SearchFilter> filters = new HashMap<String, SearchFilter>();
		//filters.put("level", new SearchFilter("level", Operator.GT, 0));
		filters.put("expired", new SearchFilter("expired", Operator.EQ, 0));
		//filters.put("step", new SearchFilter("step", Operator.EQ, "2"));
		Specification<TUser> spec = DynamicSpecifications.bySearchFilter(filters.values(), TUser.class);
		return userRepository.findAll(spec, new Sort(Direction.DESC, "id"));
	}
}
