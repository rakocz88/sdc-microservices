package com.pilaf.sdc.core.user.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pilaf.sdc.core.json.MailMsg;

@Service
public class MailService {

    public String sendMail(MailMsg msg) {
	ResponseEntity<String> response = new RestTemplate().postForEntity("http://localhost:" + 8083 + "/mail/send",
		msg, String.class);
	return response.getBody();

    }

}
