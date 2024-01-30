package com.SDUUTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = ".\\src\\test\\resources\\com\\SDUU\\Features",
					glue = "com.SDUUStepDefinition",
					//tags = "@validCredentials",
					monochrome = true,
					dryRun = false,	
					stepNotifications = true,
					plugin = {
						    "pretty",
						    "html:target/cucumber-reports/cucumber.html",
						    "json:target/cucumber-reports/cucumber.json",
						    "junit:target/cucumber-reports/cucumber.xml",
						    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html",
						    "rerun:target/failed.txt"
						}
				
	)
	public class TestRunner {


}
