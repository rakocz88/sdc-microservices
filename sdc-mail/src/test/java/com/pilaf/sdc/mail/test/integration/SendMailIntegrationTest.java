package com.pilaf.sdc.mail.test.integration;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pilaf.sdc.mail.MailApplication;
import com.pilaf.sdc.mail.json.MailMsg;
import com.pilaf.sdc.mail.model.MessageType;
import com.pilaf.sdc.mail.model.OutputMsgDO;
import com.pilaf.sdc.mail.repository.OutputMsgRepository;
import com.pilaf.sdc.mail.test.TestConstants;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MailApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SendMailIntegrationTest implements TestConstants {

	@Value("${local.server.port}")
	private int port;

	@Autowired
	private OutputMsgRepository outputMsgRepository;

	@Before
	public void init() {

	}

	@Test
	public void getBySenderTest() {
		outputMsgRepository.save(
				new OutputMsgDO(ID_1, RECIPENT_ADDRESS_1, SENDER_ID_1, LocalDate.now(), TEST_MSG_1, MessageType.MAIL));
		ResponseEntity<OutputMsgDO[]> entity = new TestRestTemplate()
				.getForEntity("http://localhost:" + this.port + "/mail/bySender/1", OutputMsgDO[].class);
		assertThat("Wrong response status", HttpStatus.OK.equals(entity.getStatusCode()));
		assertThat("Wrong size of list of OutputMessages", entity.getBody().length == 1);
		outputMsgRepository.delete(ID_1);
	}

	@Test
	public void sentMailTest() {
		ResponseEntity<OutputMsgDO> entity = new TestRestTemplate().postForEntity(
				"http://localhost:" + this.port + "/mail/send",
				new MailMsg(TEST_MSG_2, RECIPENT_ADDRESS_2, SENDER_ID_1), OutputMsgDO.class);
		assertThat("Wrong response status", HttpStatus.OK.equals(entity.getStatusCode()));
		int size = 0;
		for (@SuppressWarnings("unused")
		OutputMsgDO outputMsg : outputMsgRepository.findAll()) {
			size++;
		}
		assertThat("OutputMsg size is not correct", size == 1);
	}

}
