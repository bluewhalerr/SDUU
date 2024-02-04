package com.SDUUStepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SDUU.BaseM;
import com.SDUU.ConigReader;
import com.SDUUPom.LoginPage;

public class demo2 extends BaseM {
	public static WebDriver driver;
	public static LoginPage lp;
	public static ConigReader cr;
	public static void main(String[] args) throws Throwable {

	driver=launchBrowser("chrome");
	lp = new LoginPage(driver);
	driver = getUrl(cr.getInstance().getProperty("url"));
	userInput(lp.getUseName(),cr.getInstance().getProperty("username"));
	userInput(lp.getPassword(),cr.getInstance().getProperty("password"));
	eclick(lp.getLoginBtn());
	// login

	// srm transact
	WebElement srmTransact = driver.findElement(By.xpath("//span[contains(text(),' SRM Transaction')]"));

	scrollIntoView(srmTransact);

	eclick(srmTransact);

	WebElement directPO = driver.findElement(By.xpath("//span[contains(text(),'Direct PO')]"));

	eclick(directPO);

	framesWindowSwitch("PagePane", 0, null);
	
	WebElement supplierName = driver.findElement(By.id("ddlBasicInformation_SupplierName_Input"));
	
	supplierName.clear();
	supplierName.sendKeys("A3S ENTERPRISES");
    
    WebElement indentNo = driver.findElement(By.id("txtBasicInformation_IndentNo"));
    indentNo.sendKeys("123");
    
    WebElement department = driver.findElement(By.id("ddlBasicInformation_Department_Input"));
    department.clear();
    department.sendKeys("Allied Health Sciences");
    
    WebElement billingSite = driver.findElement(By.id("ddlBasicInformation_BillingSite_Input"));
    billingSite.clear();
    billingSite.sendKeys("SRI DEVARAJ URS ACADEMY OF HIGHER EDUCATION & RESEARCH");
    
    
    WebElement indentDateIcon = driver.findElement(By.id("rdpBasicInformation_IndentDate_popupButton"));
    indentDateIcon.click();
    
    WebElement indentDateCalendar = driver.findElement(By.id("rdpBasicInformation_IndentDate_popupButton"));
	waituntilElementVisibility(30,indentDateCalendar);
    
	WebElement desiredIndentDate = driver.findElement(By.xpath("(//td[@title='Thursday, February 01, 2024'])[1]"));
	desiredIndentDate.click();
	
	WebElement commonDeliveryDate = driver.findElement(By.id("rdpBasicInformation_CommonDeliveryDate_popupButton"));
	commonDeliveryDate.click();
    
	WebElement commonDeliveryCalendar = driver.findElement(By.id("rdpBasicInformation_CommonDeliveryDate_calendar"));
	waituntilElementVisibility(30,commonDeliveryCalendar);
	
	WebElement desiredcommonDeliveryDate = driver.findElement(By.xpath("(//td[@title='Saturday, February 10, 2024'])[1]"));
	desiredcommonDeliveryDate.click();
	
	WebElement itemTextbox = driver.findElement(By.id("dgItemDetails_ctl00_ctl04_rgEditItem_Input"));
	itemTextbox.sendKeys("2 MODULE METAL BOX");
	
	WebElement quantityTextbox = driver.findElement(By.xpath("(//input[contains(@id, 'rgEditQty')])[1]"));
	quantityTextbox.sendKeys("1");
	
	WebElement rateTextbox = driver.findElement(By.xpath("//input[@id='dgItemDetails_ctl00_ctl04_rgEditRate']"));
	rateTextbox.sendKeys("8");
	
	
	


			
}
}