package com.SDUUStepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SDUU.BaseM;
import com.SDUU.ConigReader;
import com.SDUUPom.LoginPage;

public class demo extends BaseM {
	public static WebDriver driver;
	public static LoginPage lp;
	public static ConigReader cr;

	public static void main(String[] args) throws Throwable {
		// login
		driver = launchBrowser("chrome");
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

		framesWindows(0, "PagePane", null);
		
		//search with invalid po number
		WebElement searchBtn = driver.findElement(By.id("btnShowHide"));

		clickElementWithActions(searchBtn);
	
		WebElement itemDropdown = driver.findElement(By.id("ddlSearchFilter_Item_Input"));
		eclick(itemDropdown);
		inputClear(itemDropdown);
		itemDropdown.sendKeys("2 MODULE METAL BOX");
		
		WebElement supplierDropdown = driver.findElement(By.id("ddlSearchFilter_Supplier_Input"));
		
		supplierDropdown.click();

		supplierDropdown.clear();

		supplierDropdown.sendKeys("A3S ENTERPRISES");
		
		WebElement poNo = driver.findElement(By.id("txtSearchFilter_PONo"));
		poNo.sendKeys("123");
		
		WebElement poDateToIcon = driver.findElement(By.id("rdpSearchFilter_PODateTo_popupButton"));
		poDateToIcon.click();
		
		WebElement poCalendarTo = driver.findElement(By.id("rdpSearchFilter_PODateTo_calendar"));
		waituntilElementVisibility(30,poCalendarTo);
		
		WebElement desiredToDate = driver.findElement(By.xpath("(//td[@title='Saturday, February 10, 2024'])[1]"));
		desiredToDate.click();
		
		
		WebElement poDateFromIcon = driver.findElement(By.id("rdpSearchFilter_PODateFrom_popupButton"));
		poDateFromIcon.click();
		
		WebElement poCalendarFrom = driver.findElement(By.xpath("(//div[contains(@class,'RadCalendarPopup')])[1]"));
		waituntilElementVisibility(30,poCalendarFrom);
		
		WebElement desiredFromDate = driver.findElement(By.xpath("(//td[@title='Thursday, February 01, 2024'])[1]"));
		desiredFromDate.click();
		
		WebElement searchButton = driver.findElement(By.id("btnSearch"));
        searchButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement searchMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'No records to display.')]")));
        
        printValue(searchMessage);
        
        //Hide the button
        clickElementWithActions(searchBtn);
        
        driver.quit();

	}

}
