package com.qa.testscripts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_001 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\giris\\eclipse-workspace\\TestAutomation.Selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\giris\\eclipse-workspace\\TestAutomation.Selenium\\drivers\\msedgedriver.exe");
		EdgeDriver eDriver = new EdgeDriver();
	}
}
