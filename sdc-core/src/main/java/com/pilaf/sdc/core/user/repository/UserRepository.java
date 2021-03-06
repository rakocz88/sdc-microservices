package com.pilaf.sdc.core.user.repository;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pilaf.sdc.core.user.model.UserDO;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserDO, Long> {

    public UserDO findByLogin(String login);

}
