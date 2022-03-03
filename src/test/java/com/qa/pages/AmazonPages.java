package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	
	WebDriver driver;
	////1. element description into a variable reference
	//  2.  Methods that can return WebElements
	//  3.  Create an argument based constructor to fetch the browser specifications 
	//  4. at run session into which elements present should be initialized to
	/* 1. syntax
	@FindBy(locator="value")
	WebElement refName;
	*/
	@FindBy(id="searchDropdownBox")
	WebElement Category;
	
	public Select getCategory() {
		Select cat = new Select(Category);
		return cat;
	}
	
	
	@FindBy(id="twotabsearchtextbox")
	WebElement Box;
	
	public WebElement getBox() {
		return Box;
	
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement Magnify;
	
	public WebElement getMagnify() {
		return Magnify;
	}
	@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal'] "))
	List<WebElement> ItemName;
	public List<WebElement> getItemName() {
		return ItemName;
	}
	
	@FindAll(@FindBy(className="nav_a"))
	List<WebElement> footerLinks;
	
    public List<WebElement> getfooterLinks(){
    	return footerLinks;
    }
	@FindBy(id="nav-link-accountList")
	WebElement AccountsandLists;
	
	public WebElement getAccountsandLists() {
		return AccountsandLists;
	}
	
	@FindBy(linkText="Start here.")
	WebElement startHereLink;
	
	public WebElement getstartHereLink() {
		return startHereLink;
	}
		
	
	public AmazonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}



	
}
