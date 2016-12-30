package com.pilaf.sdc.test.integration.steps.user;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.pilaf.sdc.mail.model.OutputMsgDO;
import com.pilaf.sdc.test.Constants;
import com.pilaf.sdc.user.json.UserJSON;
import com.pilaf.sdc.user.model.ContactDO;
import com.pilaf.sdc.user.model.UserActivationCodeDO;
import com.pilaf.sdc.user.model.UserDO;
import com.pilaf.sdc.user.model.UserType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserSteps implements Constants {

	private UserJSON userJson;
	private ResponseEntity<UserDO> entity;
	private String activationCode;

	@Given("^I am a user with no account$")
	public void i_am_a_user_with_no_account() throws Throwable {

	}

	@When("^I fill the user data with login= \"(.*?)\" and password= \"(.*?)\" and firstname = \"(.*?)\" and surname = \"(.*?)\" and email= \"(.*?)\"$")
	public void i_fill_the_user_data_with_login_and_password_and_firstname_and_surname_and_email(String login,
			String password, String firstName, String surname, String email) throws Throwable {
		userJson = new UserJSON(login, password, firstName, surname, null, null,
				Arrays.asList(new UserType[] { UserType.USER }), new ContactDO(null, email));
	}

	@When("^I send a requets to the server with the date i filled$")
	public void i_send_a_requets_to_the_server_with_the_date_i_filled() throws Throwable {
		entity = new TestRestTemplate().postForEntity(LOCALHOST + USER_PORT + "/user/register/", userJson,
				UserDO.class);
	}

	@Then("^I should recieve an email with the code to activate the user on the address \"(.*?)\"$")
	public void i_should_recieve_an_email_with_the_code_to_activate_the_user_on_the_address(String email)
			throws Throwable {
		ResponseEntity<OutputMsgDO[]> outPutMsg = new TestRestTemplate()
				.getForEntity(LOCALHOST + MAIL_PORT + "/mail/byRecipent/" + email, OutputMsgDO[].class);
		List<OutputMsgDO> filteredElems = Arrays.asList(outPutMsg.getBody()).stream()
				.filter(elem -> email.equals(elem.getRecipentMail())).collect(Collectors.toList());
		assertThat("List of email amount is wrong", filteredElems.size() == 1);
		activationCode = filteredElems.get(0).getMsg();

	}

	@Then("^I should get a response (\\d+)$")
	public void i_should_get_a_response(int arg1) throws Throwable {
		entity.getStatusCode().is2xxSuccessful();
	}

	@Then("^The code in the email should be present in the code repository for the user \"(.*?)\" and it should not be terminated$")
	public void the_code_in_the_email_should_be_present_in_the_code_repository_for_the_user_and_it_should_not_be_terminated(
			String login) throws Throwable {
		ResponseEntity<UserDO> userResponse = new TestRestTemplate()
				.getForEntity(LOCALHOST + USER_PORT + "/byLogin/" + login, UserDO.class);
		ResponseEntity<UserActivationCodeDO[]> outPutMsgResponse = new TestRestTemplate().getForEntity(
				LOCALHOST + USER_PORT + "/user/code/" + userResponse.getBody().getId(), UserActivationCodeDO[].class);
		assertThat("Wrong response type for codes", outPutMsgResponse.getStatusCode().is2xxSuccessful());
	}

	@Then("^The user \"(.*?)\" should exist and have the filds pass= \"(.*?)\" , firstname = \"(.*?)\" , surname = \"(.*?)\"$")
	public void the_user_should_exist_and_have_the_filds_pass_firstname_surname(String arg1, String arg2, String arg3,
			String arg4) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^the user \"(.*?)\" should not be active$")
	public void the_user_should_not_be_active(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^The user \"(.*?)\" send the activation code to the server$")
	public void the_user_send_the_activation_code_to_the_server(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^The user \"(.*?)\" should be active$")
	public void the_user_should_be_active(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

}
