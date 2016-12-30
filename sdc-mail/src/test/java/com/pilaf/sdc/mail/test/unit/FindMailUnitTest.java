package com.pilaf.sdc.mail.test.unit;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.util.List;

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

import edu.emory.mathcs.backport.java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class FindMailUnitTest {

	private static final String RECIPENT_ADDRESS = "mail@m.pl";

	private static final Long SENDER_ID = 1l;

	private static final Long MSG_ID = 1l;

	private static final String MESSAGE_SEND = "msg";

	private static final String MAIL_SUBJECT = "subject1";

	private static final LocalDate SEND_TIME = LocalDate.now();

	private OutputMsgDO returnedMsg;

	@Mock
	private OutputMsgRepository outputMsgRepository;

	@InjectMocks
	private SendMailService sendMailService;

	private MailMsg mailMsg = new MailMsg(MESSAGE_SEND, MAIL_SUBJECT, RECIPENT_ADDRESS, SENDER_ID);

	private OutputMsgDO outputMsgDO = new OutputMsgDO(MSG_ID, RECIPENT_ADDRESS, SENDER_ID, SEND_TIME, MESSAGE_SEND,
			MessageType.MAIL);

	@Before
	public void injectMocks() {
		Mockito.when(outputMsgRepository.save(new OutputMsgDO(mailMsg))).thenReturn(outputMsgDO);
		Mockito.when(outputMsgRepository.findBySenderID(SENDER_ID))
				.thenReturn(Arrays.asList(new OutputMsgDO[] { outputMsgDO }));
		returnedMsg = sendMailService.sendMail(mailMsg);

	}

	@Test
	public void testSendMail() {
		List<OutputMsgDO> returnedMessage = sendMailService.getMessagesBySender(SENDER_ID);
		assertThat("List should have one element only", returnedMessage.size() == 1);
		// assertThat("Wrong mail message",
		// outputMsgDO.getMsg().equals(returnedMsg.getMsg()));
		// assertThat("Wrong mail recipent",
		// outputMsgDO.getRecipentMail().equals(returnedMsg.getRecipentMail()));
		// assertThat("Wrong mail sender",
		// outputMsgDO.getSenderID().equals(returnedMsg.getSenderID()));
		// assertThat("Wrong message type",
		// outputMsgDO.getMessageType().equals(returnedMsg.getMessageType()));
		// assertThat("Wrong send date",
		// outputMsgDO.getSendDate().equals(returnedMsg.getSendDate()));

	}

}
