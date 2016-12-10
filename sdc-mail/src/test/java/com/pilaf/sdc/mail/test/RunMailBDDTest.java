package com.pilaf.sdc.mail.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty",
		"html:target/cucumber" }, glue = "com.pilaf.sdc.mail.test.integration.steps", features = "classpath:cucumber/mail.feature")
public class RunMailBDDTest {
}
