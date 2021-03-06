package com.pilaf.sdc.mail.test.integration.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.pilaf.sdc.mail.json.MailMsg;
import com.pilaf.sdc.mail.json.MailResponse;
import com.pilaf.sdc.mail.model.MessageType;
import com.pilaf.sdc.mail.model.OutputMsgDO;
import com.pilaf.sdc.mail.test.integration.SendMailIntegrationTestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MailSteps extends SendMailIntegrationTestBase {

	private ResponseEntity<MailResponse> entity;
	private List<OutputMsgDO> returnedList;
	private OutputMsgDO sendMessage;

	@Given("^I am a user with id (\\d+)$")
	public void i_am_a_user_with_id(int arg1) throws Throwable {
		// TODO implement login
	}

	@Given("^User (\\d+) send an email with text \"(.*?)\" and recipent \"(.*?)\"$")
	public void user_send_an_email_with_text_and_recipent(long senderId, String messageText, String recipent)
			throws Throwable {
		outputMsgRepository
				.save(new OutputMsgDO(0l, recipent, senderId, LocalDate.now(), messageText, MessageType.MAIL));
	}

	@When("^As user (\\d+) I send an email message with \"(.*?)\" to recipent \"(.*?)\" and subject \"(.*?)\"$")
	public void as_user_I_send_an_email_message_with_to_recipent(long senderId, String messageText,
			String recipentAddress, String title) throws Throwable {
		entity = new TestRestTemplate().postForEntity("http://localhost:" + this.port + "/mail/send",
				new MailMsg(messageText, title, recipentAddress, senderId), MailResponse.class);
	}

	@Then("^I should recive response with status (\\d+)$")
	public void i_should_recive_response_with_status(int statusCode) throws Throwable {
		assertThat("Status code should be 2XX", entity.getStatusCode().is2xxSuccessful());
	}

	@When("^I filter all MessageOutputs by sender with id (\\d+)$")
	public void i_filter_all_MessageOutputs_by_sender_with_id(long userId) throws Throwable {
		returnedList = outputMsgRepository.findBySenderID(userId);
	}

	@Then("^I should have (\\d+) message in filter result$")
	public void i_should_have_message_in_filter_result(int amountOfMessages) throws Throwable {
		assertThat("List should have " + amountOfMessages + " messages but had " + returnedList.size() + " messages",
				returnedList.size() == amountOfMessages);
		if (!returnedList.isEmpty()) {
			sendMessage = returnedList.get(0);
		}
	}

	@Then("^I should get a  messageoutput with message text \"(.*?)\" and recipent \"(.*?)\"$")
	public void i_should_get_a_messageoutput_with_message_text_and_recipent(String message, String recipent)
			throws Throwable {
		assertThat("Recipent address for send mail is wrong", recipent.equals(sendMessage.getRecipentMail()));
		assertThat("Mail message for send mail is wrong", message.equals(sendMessage.getMsg()));
	}
}
