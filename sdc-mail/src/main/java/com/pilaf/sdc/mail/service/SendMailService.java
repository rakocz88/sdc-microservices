package com.pilaf.sdc.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.pilaf.sdc.mail.json.MailMsg;
import com.pilaf.sdc.mail.model.OutputMsgDO;
import com.pilaf.sdc.mail.repository.OutputMsgRepository;

@Service
public class SendMailService {

    private OutputMsgRepository outputMsgRepository;

    @Autowired
    private JavaMailSenderImpl javaMailService;

    public SendMailService() {
	super();
    }

    @Autowired
    public SendMailService(OutputMsgRepository outputMsgRepository) {
	super();
	this.outputMsgRepository = outputMsgRepository;
    }

    public OutputMsgDO sendMail(MailMsg msg) {
	OutputMsgDO mailMessage = new OutputMsgDO();
	mailMessage.fillObject(msg);
	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	simpleMailMessage.setFrom(msg.getSender().toString());
	simpleMailMessage.setTo(msg.getRecipent());
	simpleMailMessage.setSubject(msg.getSubject());
	simpleMailMessage.setText(msg.getMsg());
	javaMailService.send(simpleMailMessage);
	return outputMsgRepository.save(mailMessage);
    }

    public List<OutputMsgDO> getMessagesBySender(Long senderId) {
	return outputMsgRepository.findBySenderID(senderId);
    }

    public Page<OutputMsgDO> getMessagesPage(String sortValue, int pageNumber, String direction) {
	PageRequest request = new PageRequest(pageNumber - 1, 10, Direction.fromString(direction), sortValue);
	return outputMsgRepository.findAll(request);
    }

    public List<OutputMsgDO> getMessagesByRecipent(String mail) {
	return outputMsgRepository.findByRecipentMail(mail);
    }

}
