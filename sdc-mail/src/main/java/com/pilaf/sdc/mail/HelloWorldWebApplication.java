package com.pilaf.sdc.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pilaf.sdc.mail.repository")
public class HelloWorldWebApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloWorldWebApplication.class, args);
	}

}
