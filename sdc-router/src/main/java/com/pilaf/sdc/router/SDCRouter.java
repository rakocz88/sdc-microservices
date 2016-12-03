package com.pilaf.sdc.router;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SDCRouter {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SDCRouter.class, args);
	}

}
