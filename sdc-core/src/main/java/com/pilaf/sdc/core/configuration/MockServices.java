package com.pilaf.sdc.core.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.pilaf.sdc.core.user.service.CodeGenerator;
import com.pilaf.sdc.core.user.service.MailService;

@Profile("test")
@Configuration
public class MockServices {

    @Bean
    @Primary
    public MailService mailService() {
	return Mockito.mock(MailService.class);
    }

    @Bean
    @Primary
    public CodeGenerator codeGenerator() {
	return Mockito.mock(CodeGenerator.class);
    }
}
