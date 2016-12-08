package com.pilaf.sdc.mail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pilaf.sdc.mail.model.OutputMsgDO;

public interface OutputMsgRepository extends CrudRepository<OutputMsgDO, Long> {

	public List<OutputMsgDO> findBySenderID(Long senderId);
}
