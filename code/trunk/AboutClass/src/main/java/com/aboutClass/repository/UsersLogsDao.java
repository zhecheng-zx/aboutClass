package com.aboutClass.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aboutClass.model.aboutClass.TUsersLogs;


public interface UsersLogsDao extends PagingAndSortingRepository<TUsersLogs, Long>, JpaSpecificationExecutor<TUsersLogs> {

}
