package com.aboutClass.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aboutClass.model.aboutClass.TUser;

public interface UserRepository extends PagingAndSortingRepository<TUser, Long>, JpaSpecificationExecutor<TUser> {
	TUser findUserByPhone(String phone);

	TUser findByPhone(String phone);
}
