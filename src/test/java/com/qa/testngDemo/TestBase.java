package com.qa.testngDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	@BeforeClass
	
	public void Login() {
		System.out.println("Steps for Login action");
	}
	
	@AfterClass
	public void Logout() {
		System.out.println("Steps for Logout action");
	}
	
	@BeforeTest
	public void invokeBrowser() {
		System.out.println("Launch Browser");
	}
	@AfterTest
	public void closeBrowser() {
		System.out.println("close Browser");
	}
	@BeforeMethod
	public void CheckBalance() {
		System.out.println("Available Balance");
		
	}
	@AfterMethod
	public void Acknowledgement() {
		System.out.println("Print an Acknowledgement");
		
	}


}
