package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

@Test
public class TC_Amazon_002 extends TestBase{
	public void registration() throws IOException {
		
		Actions act = new Actions(driver);
		WebElement accountsandLists = AmazonCC.getAccountsandLists();
		act.moveToElement(accountsandLists).build().perform();
		AmazonCC.getstartHereLink().click();
		boolean contains = driver.getTitle().contains("Registration");
		if(contains) {
			Reporter.log("Title has registration word");
			Assert.assertTrue(contains);
		}
		else {
			Reporter.log("Title do not have registration word");
			captureScreenshot(driver,"registration");
			Assert.assertTrue(contains);
			
		}
	}

}
