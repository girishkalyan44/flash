package com.qa.testscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Workwithpopups extends TestBase{
	@Test
	public void popup() throws InterruptedException {
		driver.findElement(By.xpath("//tbody/tr[3]/td[3]/input[1]")).sendKeys("46654");
		driver.findElement(By.xpath("//tbody/tr[3]/td[3]/input[1]")).sendKeys(Keys.TAB);
		
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr[3]/td[3]/input[1]")).clear();
		driver.findElement(By.xpath("//tbody/tr[3]/td[3]/input[1]")).sendKeys("Kalyan");
		
		driver.findElement(By.xpath("//tbody/tr[7]/td[3]/input[1]")).sendKeys("you@you.com");
		Thread.sleep(3000);
		
		
		
	}

}
