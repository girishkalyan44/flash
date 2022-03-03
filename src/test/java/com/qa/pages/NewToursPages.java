package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewToursPages {
	
	WebDriver driver;
	
	@FindBy(name="userName")
	WebElement usernameField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
	@FindBy(name="submit")
	WebElement submitButton;
	
	public WebElement getusernameField() {
		return usernameField;
	}
	public WebElement getpasswordField() {
		return passwordField;
	}
	public WebElement getsubmitButton() {
		return submitButton;
	}
	public NewToursPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
