package com.pilaf.sdc.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pilaf.sdc.mail.tets.TestBean;

@Configuration
public class WebConfig {

	@Bean
	public TestBean testBean() {
		return new TestBean();
	}

}
