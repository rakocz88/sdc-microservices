package com.pilaf.sdc.user.test.module;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pilaf.sdc.core.SdcWebApp;
import com.pilaf.sdc.core.json.UserRegisterJSON;
import com.pilaf.sdc.user.test.help.SdcTestConstants;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SdcWebApp.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserRegistrationModuleTest extends AbstractUserTest implements SdcTestConstants {

    @Before
    public void beforeTest() {
	mockServices();
    }

    private void mockServices() {
	Mockito.when(codeGenerator.generateCode()).thenReturn(USER_ACTIVATION_CODE);
	Mockito.when(mailService.sendMail(mailMsg)).thenReturn("send");
    }

    @Test
    public void registerUserSuccesScenario() {
	ResponseEntity<UserRegisterJSON> userResponse = sendUserRegistrationRequest();
	assignCreatedUserToVariable(userResponse);
	checkUserFields();
	checkUserActivationCodeExists();
	checkUserActiveStatus(false);
	sendUserActivationRequest();
	checkUserActiveStatus(true);
    }

}
