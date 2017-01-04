package com.pilaf.sdc.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pilaf.sdc.core.user.repository")
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class SdcWebApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SdcWebApp.class, args);
	}

}
