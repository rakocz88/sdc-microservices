package com.pilaf.sdc.mail.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pilaf.sdc.mail.enums.MailResponseMsg;
import com.pilaf.sdc.mail.json.MailMsg;
import com.pilaf.sdc.mail.json.MailResponse;
import com.pilaf.sdc.mail.model.OutputMsgDO;
import com.pilaf.sdc.mail.service.SendMailService;

@RestController
@RequestMapping("/mail")
public class MailRest {

	@Autowired
	private SendMailService sendMailService;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MailResponse sendMsg(@RequestBody MailMsg mailMsg) {
		this.sendMailService.sendMail(mailMsg);
		return new MailResponse(MailResponseMsg.SENT);
	}

	@ResponseBody
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "bySender/{id}", method = RequestMethod.GET)
	public List<OutputMsgDO> getMsgBySender(@PathVariable("id") Long id) {
		return sendMailService.getMessagesBySender(id);
	}

	@ResponseBody
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "page/{sortValue}/{page}/{direction}", method = RequestMethod.GET)
	public Page<OutputMsgDO> getMsgByPage(@PathVariable("page") int page, @PathVariable("sortValue") String sortValue,
			@PathVariable("direction") String direction) {
		return sendMailService.getMessagesPage(sortValue, page, direction);
	}

	@ResponseBody
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "init", method = RequestMethod.GET)
	public List<OutputMsgDO> initMsgData() {
		return sendMailService.initMsgOutputData();
	}

}
