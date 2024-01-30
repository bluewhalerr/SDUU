	package com.SDUUStepDefinition;
	
	import java.io.IOException;
	
	import org.openqa.selenium.WebDriver;
	
	import com.SDUU.BaseM;
	import com.SDUU.ConigReader;
	import com.SDUUPom.LoginPage;
	
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	
	public class LoginSteps extends BaseM {
	
		public static WebDriver driver;
		public static LoginPage lp;
		public static ConigReader cr;
	
		@Before
		public void browserSetUp(Scenario scenario) throws Throwable {
			driver = launchBrowser("chrome");
			lp = new LoginPage(driver);
		}
	
		@After
		public void tearDown(Scenario scenario) throws IOException {
			if (scenario.isFailed()) {
				takeScreenshot("fail" + scenario.getName());
				driver.quit();
			} else {
				driver.quit();
			}
		}
	
		@Given("the user in on the login page of SSDU")
		public void the_user_in_on_the_login_page_of_ssdu() throws Throwable {
			driver = getUrl(cr.getInstance().getProperty("url"));
		}
	
		@When("the user enters the valid UserID")
		public void the_user_enters_the_valid_user_id() throws Exception {
			userInput(lp.getUseName(), cr.getInstance().getProperty("username"));
		}
	
		@When("the user enters the valid Password")
		public void the_user_enters_the_valid_password() throws Exception {
			userInput(lp.getPassword(), cr.getInstance().getProperty("password"));
		}
	
		@When("the user clicks on the Login button")
		public void the_user_clicks_on_the_login_button() {
			eclick(lp.getLoginBtn());
		}
	
		@Then("the user should be logged in successfully and navigates to the Home Page")
		public void the_user_should_be_logged_in_successfully_and_navigates_to_the_home_page() {
			assertPageTitle("SDDU Education Management System");
		}
	
		@When("the user enters the {string} and {string}")
		public void the_user_enters_the_and(String UserID, String Password) {
			userInput(lp.getUseName(), UserID);
			userInput(lp.getPassword(), Password);
			eclick(lp.getLoginBtn());
		}
	
		@Then("the error message appears Your Login id or Password was not correct. is shown")
		public void the_error_message_appears_your_login_id_or_password_was_not_correct_is_shown() {
			waituntilElementVisibility(30, lp.getErrorCredentials());
			assertWebText("Your Login id or Password was not correct.", lp.getErrorCredentials());
		}
	
		@When("the user enters the missing {string} and {string}")
		public void the_user_enters_the_missing_and(String string, String string2) {
			userInput(lp.getUseName(), string);
			userInput(lp.getPassword(), string2);
			eclick(lp.getLoginBtn());
		}
	
		@Then("the username or password fields is required error message appears")
		public void the_username_or_password_fields_is_required_error_message_appears() {
			  if (lp.getMissingUser().isDisplayed()) {
			        System.out.println("Username field is required.");
			        waituntilElementVisibility(30,lp.getMissingUser());
			        assertWebText("Login ID is required.", lp.getMissingUser());
			    }
			  else if (lp.getMissingPassword().isDisplayed()) {
			        System.out.println("Password field is required.");
			    }
		}
	
	}
