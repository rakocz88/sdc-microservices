package com.pilaf.sdc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pilaf.sdc.user.repository")
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class UserWebApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UserWebApp.class, args);
	}

}
