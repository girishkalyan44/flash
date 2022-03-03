package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitiBankAppPages {
	
	WebDriver driver;
	
	
	public CitiBankAppPages(WebDriver driver) {
		
		
	    this.driver = driver;
		PageFactory.initElements(driver, this);
			
		
	}
	
	@FindBy(linkText="CITIGROUP.COM")
    WebElement citigrouplink;
	
	public WebElement getcitigrouplink() {
		return citigrouplink;
	}
	
	@FindBy(linkText="TERMS AND CONDITIONS")
	WebElement Terms;
	
	public WebElement getTerms() {
		return Terms;
	}
	
	@FindBy(linkText="MCLR")
	WebElement MCLRLink;
	
	public WebElement getMCLRLink() {
		return MCLRLink;
	}

}
