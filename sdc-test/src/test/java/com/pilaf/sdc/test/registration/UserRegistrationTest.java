package com.pilaf.sdc.test.registration;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.pilaf.sdc.core.user.model.UserDO;
import com.pilaf.sdc.test.Constants;

public class UserRegistrationTest implements Constants {

    @Test
    public void searchUserByLogin() {
	Map<String, String> uriVariables = new HashMap<>();
	ResponseEntity<UserDO> entity = new TestRestTemplate()
		.getForEntity("http://localhost:" + USER_PORT + "/user/byLogin/" + "dupa", UserDO.class, uriVariables);
	assertThat("Wrong something", entity.getStatusCode().is2xxSuccessful());
    }

}
