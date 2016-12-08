package com.pilaf.sdc.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pilaf.sdc.mail.service.SendMailService;

@Configuration
public class BeanFactory {

	@Bean
	public SendMailService mailService() {
		return new SendMailService();
	}

}
