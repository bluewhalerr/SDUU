	package com.SDUUPom;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	public class BasicInfoPage {
		
		public static WebDriver driver;
		
		@FindBy(id ="ddlBasicInformation_SupplierName_Input")
		private WebElement supplierName;
		
		@FindBy(id ="ddlBasicInformation_SupplierBranch_Input")
		private WebElement supplierBranchInput;
		
		@FindBy(xpath ="//a[@id='ddlBasicInformation_SupplierBranch_Arrow']")
		private WebElement supplierarrow;
		
		@FindBy(id ="txtBasicInformation_IndentNo")
		private WebElement indentNo;
		
		@FindBy(id ="ddlBasicInformation_CommonDeliveryWarehouse_Input")
		private WebElement wareHouse;
		
		@FindBy(id ="ddlBasicInformation_Department_Input")
		private WebElement department;
		
		@FindBy(id ="ddlBasicInformation_BillingSite_Input")
		private WebElement billingSite;
		
		@FindBy(id ="rdpBasicInformation_IndentDate_popupButton")
		private WebElement indentDateIcon;
		
		@FindBy(id ="rdpBasicInformation_IndentDate_popupButton")
		private WebElement indentDateCalendar;
		
		@FindBy(xpath ="(//td[@title='Thursday, February 01, 2024'])[1]")
		private WebElement desiredIndentDate;
		
		@FindBy(id ="rdpBasicInformation_CommonDeliveryDate_popupButton")
		private WebElement commonDeliveryDate;
		
		@FindBy(id ="rdpBasicInformation_CommonDeliveryDate_calendar")
		private WebElement commonDeliveryCalendar;
		
		@FindBy(xpath ="(//td[@title='Saturday, February 10, 2024'])[1]")
		private WebElement desiredcommonDeliveryDate;
		
		@FindBy(xpath ="//input[@name='dgItemDetails$ctl00$ctl04$rgEditItem']//parent::td/following::td")
		private WebElement arrowBtn;
		
		@FindBy(xpath ="(//div[@id='dgItemDetails_ctl00_ctl04_rgEditItem_DropDown']//child::div//child::ul//child::li)[1]")
		private WebElement material;
		
		@FindBy(xpath ="(//span[@id='dgItemDetails_ctl00_ctl04_rgEditQty_wrapper']//child::input)[1]")
		private WebElement quantityTextbox;
		
		@FindBy(xpath ="//input[@id='dgItemDetails_ctl00_ctl04_rgEditRate']")
		private WebElement rateTextbox;
		
		@FindBy(id ="btnCalculate")
		private WebElement calculateButton;
		
		@FindBy(id ="dgDiscountAndCharges_ctl00_ctl04_rgEditDiscountType_Input")
		private WebElement discountDropdownElemet;
		
		@FindBy(xpath ="(//div[@id='dgDiscountAndCharges_ctl00_ctl04_rgEditDiscountType_DropDown']//child::div//child::ul/li)[2]")
		private WebElement discountOptions;
		
		@FindBy(id ="dgDiscountAndCharges_ctl00_ctl04_rgEditGSTSlab_Input")
		private WebElement gstDropdown;
		
		@FindBy(xpath ="(//ul[@class='rcbList']/li)[2]")
		private WebElement desiredOption;
		
		@FindBy(xpath ="//input[@title='Save']")
		private WebElement saveButton;
		
		public BasicInfoPage (WebDriver driver) {
			BasicInfoPage.driver = driver;
			PageFactory.initElements(driver,this);
		}
		
		public WebElement getSupplierName() {
			return supplierName;
		}
	
		public WebElement getSupplierBranchInput() {
			return supplierBranchInput;
		}
	
		public WebElement getSupplierarrow() {
			return supplierarrow;
		}
	
		public WebElement getIndentNo() {
			return indentNo;
		}
	
		public WebElement getWareHouse() {
			return wareHouse;
		}
	
		public WebElement getDepartment() {
			return department;
		}
	
		public WebElement getBillingSite() {
			return billingSite;
		}
	
		public WebElement getIndentDateIcon() {
			return indentDateIcon;
		}
	
		public WebElement getIndentDateCalendar() {
			return indentDateCalendar;
		}
	
		public WebElement getDesiredIndentDate() {
			return desiredIndentDate;
		}
	
		public WebElement getCommonDeliveryDate() {
			return commonDeliveryDate;
		}
	
		public WebElement getCommonDeliveryCalendar() {
			return commonDeliveryCalendar;
		}
	
		public WebElement getDesiredcommonDeliveryDate() {
			return desiredcommonDeliveryDate;
		}
	
		public WebElement getArrowBtn() {
			return arrowBtn;
		}
	
		public WebElement getMaterial() {
			return material;
		}
	
		public WebElement getQuantityTextbox() {
			return quantityTextbox;
		}
	
		public WebElement getRateTextbox() {
			return rateTextbox;
		}
	
		public WebElement getCalculateButton() {
			return calculateButton;
		}
	
		public WebElement getDiscountDropdownElemet() {
			return discountDropdownElemet;
		}
	
		public WebElement getDiscountOptions() {
			return discountOptions;
		}
	
		public WebElement getGstDropdown() {
			return gstDropdown;
		}
	
		public WebElement getDesiredOption() {
			return desiredOption;
		}
	
		public WebElement getSaveButton() {
			return saveButton;
		}
		
	
	}
