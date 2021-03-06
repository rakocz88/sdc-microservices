package com.pilaf.sdc.core.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pilaf.sdc.core.user.model.UserActivationCodeDO;
import com.pilaf.sdc.core.user.model.UserDO;

@Repository
public interface UserActivationCodeRepository extends CrudRepository<UserActivationCodeDO, Long> {

	public List<UserActivationCodeDO> findByUser(UserDO user);

}
