package com.pilaf.sdc.core.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pilaf.sdc.core.user.model.RoleDO;
import com.pilaf.sdc.core.user.model.UserDO;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<RoleDO, Long> {

    List<RoleDO> findByUsers(UserDO user);

}
