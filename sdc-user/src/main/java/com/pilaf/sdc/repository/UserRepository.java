package com.pilaf.sdc.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pilaf.sdc.model.UserDO;

@Repository
public interface UserRepository extends CrudRepository<UserDO,Long> {

	

}
