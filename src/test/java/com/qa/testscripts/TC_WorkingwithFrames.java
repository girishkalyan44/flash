package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_WorkingwithFrames extends TestBase {
	
	@Test(priority=1)
	
	public void frameById() {
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		int size = frames.size();
		System.out.println("Total frames:" + size);
		for(int i=0 ; i<size ; i++) {
			
			WebDriver frame = driver.switchTo().frame(i);
			int size2 = frame.findElements(By.tagName("a")).size();
			
			System.out.println("Total links in frame:" + i +"are :" + size2);
			driver.switchTo().defaultContent();
		}
		   
		
		
		
	}
	
	//switch to frame by unique name
	@Test(priority=2)
    public void frameByName() {
		
		WebDriver frame = driver.switchTo().frame("packageListFrame");
		System.out.println(frame.getTitle());
		driver.switchTo().defaultContent();
		
		
	}
	@Test(priority=3)
    public void frameByElement() {
		WebElement ele = driver.findElement(By.xpath("//frame[@src='allclasses-frame.html']"));
		WebDriver frame = driver.switchTo().frame(ele);
		System.out.println(frame.getTitle());
		WebElement arrayLink = frame.findElement(By.linkText("ArrayType"));
		if(arrayLink.isDisplayed()) {
			System.out.println(arrayLink.getAttribute("herf"));
			arrayLink.click();
		}
		
	}

}
