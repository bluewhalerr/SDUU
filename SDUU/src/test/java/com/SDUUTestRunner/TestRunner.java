	package com.SDUUTestRunner;
	
	import java.io.IOException;
	
	import org.junit.runner.RunWith;
	import org.openqa.selenium.WebDriver;
	
	import com.SDUU.BaseM;
	import com.SDUUPom.LoginPage;
	
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;
	
	@RunWith(Cucumber.class)
	@CucumberOptions(features = ".\\src\\test\\resources\\com\\SDUU\\Features\\DirectPO.feature", glue = "com.SDUUStepDefinition",
			// tags = "@validCredentials",
			monochrome = true, 
			dryRun = false, 
			
			stepNotifications = true, 
			plugin = { "pretty",
					"html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json",
					"junit:target/cucumber-reports/cucumber.xml",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html",
					"rerun:target/failed.txt" }
	
	)
	public class TestRunner{
		
	}
