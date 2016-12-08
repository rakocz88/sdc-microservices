package com.pilaf.sdc.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilaf.sdc.mail.json.MailMsg;
import com.pilaf.sdc.mail.model.OutputMsgDO;
import com.pilaf.sdc.mail.repository.OutputMsgRepository;

@Service
public class SendMailService {

	@Autowired
	private OutputMsgRepository outputMsgRepository;

	public OutputMsgDO sendMail(MailMsg msg) {
		OutputMsgDO mailMessage = new OutputMsgDO(msg);
		return outputMsgRepository.save(mailMessage);
	}

	public List<OutputMsgDO> getMessagesBySender(Long senderId) {
		return outputMsgRepository.findBySenderID(senderId);
	}

}