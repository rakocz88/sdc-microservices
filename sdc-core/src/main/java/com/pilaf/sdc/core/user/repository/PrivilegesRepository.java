package com.pilaf.sdc.core.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pilaf.sdc.core.user.model.PrivilegeDO;

@Repository
public interface PrivilegesRepository extends PagingAndSortingRepository<PrivilegeDO, Long> {

}
