package com.pilaf.sdc.mail.test.unit;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.pilaf.sdc.mail.json.MailMsg;
import com.pilaf.sdc.mail.model.MessageType;
import com.pilaf.sdc.mail.model.OutputMsgDO;
import com.pilaf.sdc.mail.repository.OutputMsgRepository;
import com.pilaf.sdc.mail.service.SendMailService;

@RunWith(MockitoJUnitRunner.class)
public class SendMailUnitTest {

	private static final String RECIPENT_ADDRESS = "mail@m.pl";

	private static final Long SENDER_ID = 1l;

	private static final Long MSG_ID = 1l;

	private static final String MESSAGE_SEND = "msg";

	private static final String MESSAGE_SUBJECT = "msg";

	private static final LocalDate SEND_TIME = LocalDate.now();

	@Mock
	private OutputMsgRepository outputMsgRepository;

	@InjectMocks
	private SendMailService sendMailService;

	private MailMsg mailMsg = new MailMsg(MESSAGE_SEND, MESSAGE_SUBJECT, RECIPENT_ADDRESS, SENDER_ID);

	private OutputMsgDO outputMsgDO = new OutputMsgDO(MSG_ID, RECIPENT_ADDRESS, SENDER_ID, SEND_TIME, MESSAGE_SEND,
			MessageType.MAIL);

	@Before
	public void injectMocks() {
		Mockito.when(outputMsgRepository.save(new OutputMsgDO(mailMsg))).thenReturn(outputMsgDO);

	}

	@Test
	public void testSendMail() {
		OutputMsgDO returnedMsg = sendMailService.sendMail(mailMsg);
		assertThat("Wrong mail message", outputMsgDO.getMsg().equals(returnedMsg.getMsg()));
		assertThat("Wrong mail recipent", outputMsgDO.getRecipentMail().equals(returnedMsg.getRecipentMail()));
		assertThat("Wrong mail sender", outputMsgDO.getSenderID().equals(returnedMsg.getSenderID()));
		assertThat("Wrong message type", outputMsgDO.getMessageType().equals(returnedMsg.getMessageType()));
		assertThat("Wrong send date", outputMsgDO.getSendDate().equals(returnedMsg.getSendDate()));

	}

}
