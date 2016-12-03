package com.pilaf.sdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration()
@EnableJpaRepositories("com.pilaf.sdc.repository")
public class UserWebApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UserWebApp.class, args);
	}

}
