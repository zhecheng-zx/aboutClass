package com.aboutClass.service.system;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.aboutClass.model.aboutClass.TUserPackage;
import com.aboutClass.repository.UserPackageRepository;
import com.aboutClass.utils.DynamicSpecifications;
import com.aboutClass.utils.SearchFilter;
import com.aboutClass.utils.SearchFilter.Operator;
import com.aboutClass.utils.shiroUtils;
/** 
* @author DengJie 
* @version 创建时间：2016年10月25日
* 类说明:
*/
@Service
public class UserPackageService {
	@Autowired
	private UserPackageRepository userPackageRepository;
	
	public TUserPackage findOne(Long id){
		return userPackageRepository.findOne(id);
	}
	
	public TUserPackage findOneByUserId(Long uid){
		Map<String, SearchFilter> filters = new HashMap<String, SearchFilter>();
		filters.put("userId", new SearchFilter("userId", Operator.EQ, uid));
		Specification<TUserPackage> spec = DynamicSpecifications.bySearchFilter(filters.values(), TUserPackage.class);
		return userPackageRepository.findOne(spec);
	}
	
	
	/**
	 * 更新数据库中和shiro中的用户package
	 * @param tUserPackage
	 * @return
	 */
	public TUserPackage updateTUserPackage(TUserPackage tUserPackage){
		shiroUtils.updateShiroUPackage(tUserPackage);
		return userPackageRepository.save(tUserPackage);
	}
}
