package com.pilaf.sdc.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pilaf.sdc.mail.repository")
@PropertySource("classpath:application.properties")
public class MailApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MailApplication.class, args);
	}

}