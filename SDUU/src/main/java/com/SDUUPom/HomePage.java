package com.SDUUPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static WebDriver driver;
	
	@FindBy(xpath ="//span[contains(text(),' SRM Transaction')]")
	private WebElement srmTransact;
	
	@FindBy(xpath ="//span[contains(text(),'Direct PO')]")
	private WebElement directPO;
	
	@FindBy(id ="btnShowHide")
	private WebElement searchBtn;
	
	@FindBy(id ="ddlSearchFilter_Item_Input")
	private WebElement itemDropdown;
	
	@FindBy(id ="ddlSearchFilter_Supplier_Input")
	private WebElement supplierDropdown;
	
	@FindBy(id ="txtSearchFilter_PONo")
	private WebElement poNo;
	
	@FindBy(id ="rdpSearchFilter_PODateTo_popupButton")
	private WebElement poDateToIcon;
	
	@FindBy(id ="rdpSearchFilter_PODateTo_calendar")
	private WebElement poCalendarTo;
	
	@FindBy(xpath ="(//td[@title='Saturday, February 10, 2024'])[1]")
	private WebElement desiredToDate;
	
	@FindBy(id ="rdpSearchFilter_PODateFrom_popupButton")
	private WebElement poDateFromIcon;
	
	@FindBy(xpath ="(//div[contains(@class,'RadCalendarPopup')])[1]")
	private WebElement poCalendarFrom;
	
	@FindBy(xpath ="(//td[@title='Thursday, February 01, 2024'])[1]")
	private WebElement desiredFromDate;
	
	@FindBy(id ="btnSearch")
	private WebElement searchButton;
	
	@FindBy(xpath ="//div[contains(text(),'No records to display.')]")
	private WebElement searchMessage;
	
	public HomePage (WebDriver driver) {
		HomePage.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public WebElement getSrmTransact() {
		return srmTransact;
	}


	public WebElement getDirectPO() {
		return directPO;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getItemDropdown() {
		return itemDropdown;
	}


	public WebElement getSupplierDropdown() {
		return supplierDropdown;
	}


	public WebElement getPoNo() {
		return poNo;
	}


	public WebElement getPoDateToIcon() {
		return poDateToIcon;
	}


	public WebElement getPoCalendarTo() {
		return poCalendarTo;
	}


	public WebElement getDesiredToDate() {
		return desiredToDate;
	}


	public WebElement getPoDateFromIcon() {
		return poDateFromIcon;
	}


	public WebElement getPoCalendarFrom() {
		return poCalendarFrom;
	}


	public WebElement getDesiredFromDate() {
		return desiredFromDate;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}


	public WebElement getSearchMessage() {
		return searchMessage;
	}
}
