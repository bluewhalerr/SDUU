package com.SDUUStepDefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SDUU.BaseM;
import com.SDUU.ConigReader;
import com.SDUUPom.LoginPage;

public class demo2 extends BaseM {
	public static WebDriver driver;
	public static LoginPage lp;
	public static ConigReader cr;

	public static void main(String[] args) throws Throwable {

		driver = launchBrowser("chrome");
		lp = new LoginPage(driver);
		driver = getUrl(cr.getInstance().getProperty("url"));
		userInput(lp.getUseName(), cr.getInstance().getProperty("username"));
		userInput(lp.getPassword(), cr.getInstance().getProperty("password"));
		eclick(lp.getLoginBtn());
		// login

		// srm transact
		WebElement srmTransact = driver.findElement(By.xpath("//span[contains(text(),' SRM Transaction')]"));

		scrollIntoView(srmTransact);

		eclick(srmTransact);

		WebElement directPO = driver.findElement(By.xpath("//span[contains(text(),'Direct PO')]"));

		eclick(directPO);

		framesWindows(0, "PagePane", null);

		WebElement supplierName = driver.findElement(By.id("ddlBasicInformation_SupplierName_Input"));

		supplierName.clear();
		supplierName.sendKeys("A3S ENTERPRISES");
		
		WebElement supplierBranchInput = driver.findElement(By.id("ddlBasicInformation_SupplierBranch_Input"));
		supplierBranchInput.clear();
		supplierBranchInput.sendKeys("# 105, Brigade, M.M Annexe Block K.R ROAD, JAYANAGAR Bangalore");
		
		WebElement supplierarrow = driver.findElement(By.xpath("//a[@id='ddlBasicInformation_SupplierBranch_Arrow']"));
		supplierarrow.click();
		

		WebElement indentNo = driver.findElement(By.id("txtBasicInformation_IndentNo"));
		indentNo.sendKeys("123");
		
		WebElement wareHouse = driver.findElement(By.id("ddlBasicInformation_CommonDeliveryWarehouse_Input"));
		wareHouse.clear();
		wareHouse.sendKeys("Engineering Store Inward");

		WebElement department = driver.findElement(By.id("ddlBasicInformation_Department_Input"));
		department.clear();
		department.sendKeys("Allied Health Sciences");

		WebElement billingSite = driver.findElement(By.id("ddlBasicInformation_BillingSite_Input"));
		billingSite.clear();
		billingSite.sendKeys("SRI DEVARAJ URS ACADEMY OF HIGHER EDUCATION & RESEARCH");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		WebElement indentDateIcon = driver.findElement(By.id("rdpBasicInformation_IndentDate_popupButton"));
		indentDateIcon.click();

		WebElement indentDateCalendar = driver.findElement(By.id("rdpBasicInformation_IndentDate_popupButton"));
		waituntilElementVisibility(30, indentDateCalendar);

		WebElement desiredIndentDate = driver.findElement(By.xpath("(//td[@title='Thursday, February 01, 2024'])[1]"));
		desiredIndentDate.click();

		WebElement commonDeliveryDate = driver.findElement(By.id("rdpBasicInformation_CommonDeliveryDate_popupButton"));
		commonDeliveryDate.click();

		WebElement commonDeliveryCalendar = driver
				.findElement(By.id("rdpBasicInformation_CommonDeliveryDate_calendar"));
		waituntilElementVisibility(30, commonDeliveryCalendar);

		WebElement desiredcommonDeliveryDate = driver
				.findElement(By.xpath("(//td[@title='Saturday, February 10, 2024'])[1]"));
		desiredcommonDeliveryDate.click();
		
//		WebElement deliveryAddress = driver.findElement(By.id("txtBasicInformation_DelAddress"));
//		deliveryAddress.sendKeys("M.M Annexe Block K.R ROAD, JAYANAGAR Bangalore");
		
		
		
		Thread.sleep(2000);
		WebElement arrowBtn = driver.findElement(
				By.xpath("//input[@name='dgItemDetails$ctl00$ctl04$rgEditItem']//parent::td/following::td"));
		arrowBtn.click();

		WebElement material = driver.findElement(By.xpath(
				"(//div[@id='dgItemDetails_ctl00_ctl04_rgEditItem_DropDown']//child::div//child::ul//child::li)[1]"));
		
		waituntilElementVisibility(30, material);
		material.click();

		waitForAlert(30);
		alertPopUp();

		WebElement quantityTextbox = driver
				.findElement(By.xpath("(//span[@id='dgItemDetails_ctl00_ctl04_rgEditQty_wrapper']//child::input)[1]"));
		waituntilElementClickable(30, quantityTextbox);
		quantityTextbox.click();
		Thread.sleep(2000);
		quantityTextbox.sendKeys("1");

		WebElement rateTextbox = driver.findElement(By.xpath("//input[@id='dgItemDetails_ctl00_ctl04_rgEditRate']"));
		rateTextbox.sendKeys("8");

		WebElement calculateButton = driver.findElement(By.id("btnCalculate"));
		calculateButton.click();
		
		 WebElement discountDropdownElemet = driver.findElement(By.id("dgDiscountAndCharges_ctl00_ctl04_rgEditDiscountType_Input"));
		 scrollIntoView(discountDropdownElemet);
		 clickElementWithActions(discountDropdownElemet);
		 
		 WebElement discountOptions = driver.findElement(By.xpath("(//div[@id='dgDiscountAndCharges_ctl00_ctl04_rgEditDiscountType_DropDown']//child::div//child::ul/li)[2]"));
		 clickElementWithActions(discountOptions);
		 
		 WebElement gstDropdown = driver.findElement(By.id("dgDiscountAndCharges_ctl00_ctl04_rgEditGSTSlab_Input"));
		 gstDropdown.click();
		 
		
		 WebElement desiredOption = driver.findElement(By.xpath("(//ul[@class='rcbList']/li)[2]"));
		 desiredOption.click();
		 
//		 WebElement gstArrow = driver.findElement(By.xpath("dgDiscountAndCharges_ctl00_ctl04_rgEditGSTSlab_Arrow"));
//		 gstArrow.click();
		 
		 Thread.sleep(2000);
		 scrollToTop();
			
		 //Form1
		 //
		 WebElement saveButton = driver.findElement(By.xpath("//input[@title='Save']"));
		 clickElementWithActions(saveButton);
		 
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//		WebElement calculatorBox = driver.findElement(By.id("txtBasicInformation_POTotal"));
//		Boolean value = wait.until(ExpectedConditions.textToBePresentInElement(calculatorBox, "9.00"));
//
//		String updatedValue = calculatorBox.getAttribute("value");
//		System.out.println("Updated Total Value: " + updatedValue);

		 //driver.quit();
	}
}