package com.SDUUPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	@FindBy(xpath ="//td[contains(text(),'Login ID')]/following-sibling::td/child::input")
	private WebElement useName;
	
	
	@FindBy(xpath ="//td[contains(text(),'Login ID')]/parent::tr/following::tr/child::td/following::td/child::input")
	private WebElement password;
	
	@FindBy(xpath ="//input[@value='Sign In']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Your Login id or Password')]")
	private WebElement errorCredentials;
	
	@FindBy(xpath = "//td[contains(text(),'Login ID')]/following-sibling::td/child::input/following::span")
	private WebElement missingUser;
	
	@FindBy(xpath = "//td[contains(text(),'Login ID')]/parent::tr/following::tr/child::td/following::td/child::input/following::span[contains(text(),'Password is required.')]")
	private WebElement missingPassword;
	

	public LoginPage (WebDriver driver) {
		LoginPage.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getUseName() {
		return useName;
	}
	
	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getErrorCredentials() {
		return errorCredentials;
	}

	public WebElement getMissingUser() {
		return missingUser;
	}

	public WebElement getMissingPassword() {
		return missingPassword;
	}
}
