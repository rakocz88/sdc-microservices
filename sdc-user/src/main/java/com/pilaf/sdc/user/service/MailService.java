package com.pilaf.sdc.user.service;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pilaf.sdc.user.json.MailMsg;

@Service
public class MailService {

	public String sendMail(MailMsg msg) {
		ResponseEntity<String> response = new TestRestTemplate()
				.postForEntity("http://localhost:" + 8083 + "/mail/send", msg, String.class);
		return response.getBody();
	}

}
