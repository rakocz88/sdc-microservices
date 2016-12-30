package com.pilaf.sdc.mail.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.pilaf.sdc.mail.json.MailMsg;
import com.pilaf.sdc.mail.model.MessageType;
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

	public List<OutputMsgDO> initMsgOutputData() {
		outputMsgRepository.save(new OutputMsgDO(0, "raw1@r.pl", 1l, LocalDate.now(), "msg1", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw2@r.pl", 1l, LocalDate.now(), "msg2", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw3@r.pl", 1l, LocalDate.now(), "msg3", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw4@r.pl", 1l, LocalDate.now(), "msg4", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw5@r.pl", 1l, LocalDate.now(), "msg5", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw6@r.pl", 1l, LocalDate.now(), "msg6", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw7@r.pl", 1l, LocalDate.now(), "msg7", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw8@r.pl", 1l, LocalDate.now(), "msg8", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw9@r.pl", 1l, LocalDate.now(), "msg9", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw10@r.pl", 1l, LocalDate.now(), "msg10", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw11@r.pl", 1l, LocalDate.now(), "msg11", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw12@r.pl", 1l, LocalDate.now(), "msg12", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw13@r.pl", 1l, LocalDate.now(), "msg13", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw14@r.pl", 1l, LocalDate.now(), "msg14", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw15@r.pl", 1l, LocalDate.now(), "msg15", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw16@r.pl", 1l, LocalDate.now(), "msg16", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw17@r.pl", 1l, LocalDate.now(), "msg17", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw18@r.pl", 1l, LocalDate.now(), "msg18", MessageType.MAIL));
		outputMsgRepository.save(new OutputMsgDO(0, "raw19@r.pl", 1l, LocalDate.now(), "msg19", MessageType.MAIL));
		return new ArrayList<>();
	}

}
