package com.pilaf.sdc.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty",
		"html:target/cucumber" }, glue = "com.pilaf.sdc.test.integration.steps.user", features = "classpath:cucumber/user.feature")
public class RunBDDTest {
}
