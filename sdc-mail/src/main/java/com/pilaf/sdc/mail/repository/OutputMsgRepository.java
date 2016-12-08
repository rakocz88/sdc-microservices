package com.pilaf.sdc.mail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pilaf.sdc.mail.model.OutputMsgDO;

@Repository
public interface OutputMsgRepository extends CrudRepository<OutputMsgDO, Long> {

	public List<OutputMsgDO> findBySenderID(Long senderId);
}
