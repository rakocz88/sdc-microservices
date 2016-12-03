package com.pilaf.sdc.mail.repository;

import org.springframework.data.repository.CrudRepository;

import com.pilaf.sdc.mail.model.MailDO;

public interface MailRepository extends CrudRepository<MailDO, Long> {

}
