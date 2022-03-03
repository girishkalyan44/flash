package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;
import com.qa.pages.CitiBankAppPages;
import com.qa.pages.NewToursPages;

public class TestBase {
	WebDriver driver;
	AmazonPages AmazonCC;
	NewToursPages NewTourCC;
	FileInputStream fileloc;
	Properties prop;
	CitiBankAppPages CitiBankCC;
	
    @Parameters({"Browser","Url"})
	@BeforeClass
	public void setProperty(String Browser, String Url) throws IOException {
    	
    	fileloc = new FileInputStream("C:\\Users\\giris\\eclipse-workspace\\TestAutomation.Selenium\\src\\test\\java\\com\\qa\\testdata\\credentials.properties");
    	prop = new Properties();
    	prop.load(fileloc);
    	
    	if(Browser.equalsIgnoreCase("Chrome")) {
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\giris\\eclipse-workspace\\TestAutomation.Selenium\\drivers\\chromedriver.exe");
		    driver = new ChromeDriver();
    	}
		
		else if(Browser.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\giris\\eclipse-workspace\\TestAutomation.Selenium\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
    	driver.manage().window().maximize();
		
		driver.get(Url);
		AmazonCC = new AmazonPages(driver);
		NewTourCC = new NewToursPages(driver);
		CitiBankCC = new CitiBankAppPages(driver);
		
	}
	@AfterClass
	public void breakdown() {
		driver.close();
		driver.quit();
		
	}
	
	public void captureScreenshot(WebDriver driver, String tName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+"/ScreenShot/"+tName+".png");
		FileUtils.copyFile(Source, Target);
		
	   
		
	}
}


