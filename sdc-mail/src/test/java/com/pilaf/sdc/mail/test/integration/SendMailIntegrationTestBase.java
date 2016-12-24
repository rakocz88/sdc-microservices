package com.pilaf.sdc.mail.test.integration;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pilaf.sdc.mail.MailApplication;
import com.pilaf.sdc.mail.repository.OutputMsgRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MailApplication.class, loader = SpringApplicationContextLoader.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SendMailIntegrationTestBase {

	@Value("${local.server.port}")
	protected int port;

	@Autowired
	protected OutputMsgRepository outputMsgRepository;

}
