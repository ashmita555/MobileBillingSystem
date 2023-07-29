package com.cg.mobilebilling.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"features"},
		glue= {"com.cg.mobilebilling.stepdefinition"}
		)
public class TestRunner {

}
