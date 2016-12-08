package com.pilaf.sdc.mail.test.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pilaf.sdc.mail.MailApplication;
import com.pilaf.sdc.mail.model.OutputMsgDO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MailApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SendMailIntegrationTest {

	@Value("${local.server.port}")
	private int port;

	@Test
	public void getBySenderTest() {
		ResponseEntity<OutputMsgDO[]> entity = new TestRestTemplate()
				.getForEntity("http://localhost:" + this.port + "/mail/bySender/1", OutputMsgDO[].class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		// assertEquals("Hello World", entity.getBody());
	}

}
