package com.aboutClass.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.aboutClass.model.aboutClass.TUserPackage;

/**
 * @author DengJie
 * @version 创建时间：2016年10月25日 类说明:
 */
public interface UserPackageRepository extends JpaSpecificationExecutor<TUserPackage>, CrudRepository<TUserPackage, Long> {

}
