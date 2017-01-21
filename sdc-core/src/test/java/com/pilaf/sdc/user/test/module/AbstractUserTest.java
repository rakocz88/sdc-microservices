package com.pilaf.sdc.user.test.module;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pilaf.sdc.core.json.ActivationCodeJSON;
import com.pilaf.sdc.core.json.MailMsg;
import com.pilaf.sdc.core.json.SimpleResponse;
import com.pilaf.sdc.core.json.UserRegisterJSON;
import com.pilaf.sdc.core.user.model.ContactDO;
import com.pilaf.sdc.core.user.model.UserActivationCodeDO;
import com.pilaf.sdc.core.user.model.UserDO;
import com.pilaf.sdc.core.user.repository.UserActivationCodeRepository;
import com.pilaf.sdc.core.user.repository.UserRepository;
import com.pilaf.sdc.core.user.service.CodeGenerator;
import com.pilaf.sdc.core.user.service.MailService;

public abstract class AbstractUserTest {

    @Value("${local.server.port}")
    protected int port;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected UserActivationCodeRepository userActivationCodeRepository;

    @Autowired
    protected MailService mailService;

    @Autowired
    protected CodeGenerator codeGenerator;

    protected static final String USER_LOGIN = "Login";
    protected static final String USER_PASSWORD = "pass1";
    protected static final String USER_NAME = "Jan";
    protected static final String USER_SURNAME = "Kowalski";
    protected static final String USER_MAIL = "rawa@ra.pl";
    protected static final String USER_ACTIVATION_CODE = "code";
    protected static final String MAIL_TITLE = "Witamy w SDC";

    protected MailMsg mailMsg = new MailMsg(USER_ACTIVATION_CODE, MAIL_TITLE, USER_MAIL, 1l);

    private UserDO createdUser;

    protected void sendUserActivationRequest() {
	ActivationCodeJSON activationCodeJson = new ActivationCodeJSON();
	activationCodeJson.setActivationCode(USER_ACTIVATION_CODE);
	activationCodeJson.setUserId(createdUser.getId());
	ResponseEntity<SimpleResponse> registrationResponse = new RestTemplate().postForEntity(
		"http://localhost:" + this.port + "/user/register/activate", activationCodeJson, SimpleResponse.class);
	assertThat("Error in activation request", registrationResponse.getStatusCode().is2xxSuccessful());
    }

    protected void assignCreatedUserToVariable(ResponseEntity<UserRegisterJSON> userResponse) {
	createdUser = userRepository.findOne(userResponse.getBody().getId());
    }

    protected void checkUserActiveStatus(boolean shouldBeActive) {
	createdUser = userRepository.findOne(createdUser.getId());
	assertThat(String.format("User has wrong activation status. User should be active %b.", shouldBeActive),
		shouldBeActive ? createdUser.isActive() : !createdUser.isActive());
    }

    protected void checkUserActivationCodeExists() {
	List<UserActivationCodeDO> userCodeList = userActivationCodeRepository.findByUser(createdUser);
	userCodeList.parallelStream().filter(code -> !code.isTerminated())
		.filter(code -> code.getCode().equals(USER_ACTIVATION_CODE)).collect(Collectors.toList());
	assertThat("Code for user does not exist or user has more than one code", userCodeList.size() == 1);
    }

    protected void checkUserFields() {
	assertThat("Wrong userName", USER_LOGIN.equals(createdUser.getLogin()));
	assertThat("Wrong userName", USER_PASSWORD.equals(createdUser.getPassword()));
	assertThat("Wrong userName", USER_NAME.equals(createdUser.getFirstName()));
	assertThat("Wrong userName", USER_SURNAME.equals(createdUser.getSurname()));
	assertThat("Wrong userName", USER_MAIL.equals(createdUser.getContact().getEmailAddress()));
	assertNull("Address should be null", createdUser.getAddress());

    }

    protected ResponseEntity<UserRegisterJSON> sendUserRegistrationRequest() {
	UserRegisterJSON userRegisterJSON = new UserRegisterJSON(USER_LOGIN, USER_PASSWORD, USER_NAME, USER_SURNAME,
		null, null, null, new ContactDO(null, USER_MAIL));
	return new RestTemplate().postForEntity("http://localhost:" + this.port + "/user/register", userRegisterJSON,
		UserRegisterJSON.class);

    }

}
