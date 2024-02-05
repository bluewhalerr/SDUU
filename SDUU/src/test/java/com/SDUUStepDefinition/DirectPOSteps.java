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
	import com.SDUUPom.BasicInfoPage;
	import com.SDUUPom.HomePage;
	import com.SDUUPom.LoginPage;
	
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	
	public class DirectPOSteps extends BaseM {
	
		public static WebDriver driver;
		public static LoginPage lp;
		public static HomePage hp;
		public static BasicInfoPage bip;
		public static ConigReader cr;
	
		@Before
		public void browserSetUp(Scenario scenario) throws Throwable {
			driver = launchBrowser("chrome");
			
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
	
		@Given("User is on the Direct PO creation page")
		public void user_is_on_the_direct_po_creation_page() throws Exception {
			lp = new LoginPage(driver);
			driver = getUrl(cr.getInstance().getProperty("url"));
			waituntilElementVisibility(30, lp.getUseName());
			userInput(lp.getUseName(), cr.getInstance().getProperty("username"));
			userInput(lp.getPassword(), cr.getInstance().getProperty("password"));
			eclick(lp.getLoginBtn());
			hp = new HomePage(driver);
			scrollIntoView(hp.getSrmTransact());
			eclick(hp.getSrmTransact());
			eclick(hp.getDirectPO());
		}
	
		@When("User selects {string} from the dropdown in Basic Information tab")
		public void user_selects_from_the_dropdown_in_basic_information_tab(String string) {
			framesWindows(0, "PagePane", null);
		
			bip = new BasicInfoPage(driver);
	
			inputClear(bip.getSupplierName());
	
			userInput(bip.getSupplierName(), "A3S ENTERPRISES");
	
			inputClear(bip.getSupplierBranchInput());
	
			userInput(bip.getSupplierBranchInput(), "# 105, Brigade, M.M Annexe Block K.R ROAD, JAYANAGAR Bangalore");
			
			waituntilElementClickable(30, bip.getSupplierarrow());
			eclick(bip.getSupplierarrow());
	
			userInput(bip.getIndentNo(), "123");
	
			inputClear(bip.getWareHouse());
	
			userInput(bip.getWareHouse(), "Engineering Store Inward");
	
			inputClear(bip.getDepartment());
	
			userInput(bip.getDepartment(), "Allied Health Sciences");
	
		}
	
		@When("User enters Billing Site, Indent Date, Common Delivery Date, Department, and Delivery Address")
		public void user_enters_billing_site_indent_date_common_delivery_date_department_and_delivery_address()
				throws InterruptedException {
			inputClear(bip.getBillingSite());
	
			userInput(bip.getBillingSite(), "SRI DEVARAJ URS ACADEMY OF HIGHER EDUCATION & RESEARCH");
			
			Thread.sleep(4000);
			waituntilElementClickable(60, bip.getIndentDateIcon());
			eclick(bip.getIndentDateIcon());
	
			waituntilElementVisibility(30, bip.getIndentDateCalendar());
			waituntilElementClickable(30, bip.getIndentDateCalendar());
			eclick(bip.getDesiredIndentDate());
			
			waituntilElementClickable(30, bip.getCommonDeliveryDate());
			eclick(bip.getCommonDeliveryDate());
	
			waituntilElementVisibility(30, bip.getCommonDeliveryCalendar());
	
			eclick(bip.getDesiredcommonDeliveryDate());
	
		}
	
		@When("User selects a product and enters its quantity and price in the Item Details tab")
		public void user_selects_a_product_and_enters_its_quantity_and_price_in_the_item_details_tab()
				throws InterruptedException {
			Thread.sleep(2000);
			eclick(bip.getArrowBtn());
	
			waituntilElementVisibility(30, bip.getMaterial());
	
			eclick(bip.getMaterial());
	
			waitForAlert(30);
			alertPopUp();
	
			waituntilElementClickable(30, bip.getQuantityTextbox());
	
			eclick(bip.getQuantityTextbox());
			Thread.sleep(2000);
			userInput(bip.getQuantityTextbox(), "1");
	
			userInput(bip.getRateTextbox(), "8");
	
			scrollIntoView(bip.getDiscountDropdownElemet());
	
			clickElementWithActions(bip.getDiscountDropdownElemet());
	
			eclick(bip.getDiscountOptions());
	
			eclick(bip.getGstDropdown());
	
			eclick(bip.getDesiredOption());
	
			Thread.sleep(2000);
			scrollToTop();
	
		}
	
		@When("User presses the {string} button")
		public void user_presses_the_button(String string) {
			eclick(bip.getCalculateButton());
		}
	
		@When("User selects a {string} from the dropdown")
		public void user_selects_a_from_the_dropdown(String string) throws InterruptedException {
			scrollIntoView(bip.getDiscountDropdownElemet());
	
			clickElementWithActions(bip.getDiscountDropdownElemet());
	
			eclick(bip.getDiscountOptions());
	
			eclick(bip.getGstDropdown());
	
		}
	
		@When("User tries to select the GST option")
		public void user_tries_to_select_the_gst_option() throws InterruptedException {
			eclick(bip.getDesiredOption());
		}
	
		@Then("User should not be able to select the GST option")
		public void user_should_not_be_able_to_select_the_gst_option() throws InterruptedException {
			alertPopUp();
			Thread.sleep(2000);
			scrollToTop();
		}
	
		@Then("User clicks on the {string} button")
		public void user_clicks_on_the_button(String string) {
			WebElement saveButton = driver.findElement(By.xpath("//input[@title='Save']"));
			clickElementWithActions(saveButton);
			clickElementWithActions(bip.getSaveButton());
		}
	
		@Then("User should see a success message confirming the creation of the Direct PO record without GST")
		public void user_should_see_a_success_message_confirming_the_creation_of_the_direct_po_record_without_gst() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebDriver until = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
			driver.switchTo().frame(1);

			
			WebElement saveTxt = driver.findElement(By.xpath("//div[contains(text(),'Data Saved Successfully')]"));
			String text = saveTxt.getText();
			System.out.println(text);

			WebElement okBtn = driver.findElement(By.xpath("//span[@class='rwInnerSpan'][text()='OK']"));
			okBtn.click();

		}
	
	}
