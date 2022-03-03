package com.qa.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC_WorkwithMultiWins extends TestBase{
	
	@Test
	
	public void multipleWins() {
		
		CitiBankCC.getcitigrouplink().click();
		CitiBankCC.getTerms().click();
		CitiBankCC.getMCLRLink().click();
		Set<String> winIDs = driver.getWindowHandles();
		Iterator<String> iterator = winIDs.iterator();
		
		while(iterator.hasNext()) {
			String id = iterator.next();
			WebDriver window = driver.switchTo().window(id);
			System.out.println(window.getTitle());
			
			}
		
		
	}

}
