package com.SDUUStepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SDUU.BaseM;
import com.SDUU.ConfigHelper;
import com.SDUU.ConigReader;
import com.SDUUPom.HomePage;
import com.SDUUPom.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends BaseM {

	public static WebDriver driver;
	public static LoginPage lp;
	public static HomePage hp;
	
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
			//driver.quit();
		}
	}

	@Given("User is logged in to the application")
	public void user_is_logged_in_to_the_application() throws Throwable {
		ConigReader.getInstance();
		driver = getUrl(ConfigHelper.getProperty("url"));
		ConigReader.getInstance();
		userInput(lp.getUseName(), ConfigHelper.getProperty("username"));
		ConigReader.getInstance();
		userInput(lp.getPassword(), ConfigHelper.getProperty("password"));
		eclick(lp.getLoginBtn());
	}

	@When("User selects {string} from the SRM Transaction dropdown menu")
	public void user_selects_from_the_srm_transaction_dropdown_menu(String string) {
		hp = new HomePage(driver);

		scrollIntoView(hp.getSrmTransact());

		eclick(hp.getSrmTransact());

		eclick(hp.getDirectPO());
	}

	@When("User performs an invalid search")
	public void user_performs_an_invalid_search() {
		
		framesWindowSwitch("PagePane", 0, null);
		
		clickElementWithActions(hp.getSearchBtn(), 30);

		eclick(hp.getItemDropdown());

		inputClear(hp.getItemDropdown());

		userInput(hp.getItemDropdown(), "2 MODULE METAL BOX");

		eclick(hp.getSupplierDropdown());

		inputClear(hp.getSupplierDropdown());

		userInput(hp.getSupplierDropdown(), "A3S ENTERPRISES");

		userInput(hp.getPoNo(), "123");

		eclick(hp.getPoDateToIcon());

		waituntilElementVisibility(30, hp.getPoCalendarTo());

		eclick(hp.getDesiredToDate());

		eclick(hp.getPoDateFromIcon());

		waituntilElementVisibility(30, hp.getPoCalendarFrom());

		eclick(hp.getDesiredFromDate());

		eclick(hp.getSearchButton());
	}

	@When("{string} message should be shown")
	public void message_should_be_shown(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement searchMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'No records to display.')]")));
		printValue(searchMessage);
	}

	@Then("User clicks on the Hide Search button")
	public void user_clicks_on_the_hide_search_button() {
		clickElementWithActions(hp.getSearchButton(), 30);

		driver.quit();
	}

}
