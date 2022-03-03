package com.qa.testscripts;

import org.testng.annotations.Test;

public class TC_NewToursLogin_001 extends TestBase{
	@Test
	
	public void LoginAction() {
		NewTourCC.getusernameField().sendKeys(prop.getProperty("username"));
		NewTourCC.getpasswordField().sendKeys(prop.getProperty("password"));
		NewTourCC.getsubmitButton().click();
		
		
	}

}
