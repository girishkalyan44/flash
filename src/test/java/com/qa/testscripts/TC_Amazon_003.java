package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_003 extends TestBase{
	List<WebElement> getfooterLinks;
	
	@Test(priority=1)
	
	public void validateLinks() {
	getfooterLinks = AmazonCC.getfooterLinks();
	int count = getfooterLinks.size();
	//footer links not more tyen 50
	Assert.assertEquals(count, 50);
	}
	
	@Test(priority=2,  dependsOnMethods="validateLinks")
	public void fetchFooterLinksText() {
		
	for(WebElement links:getfooterLinks) {
		Reporter.log(links.getText(),true);
	}
	}

}
