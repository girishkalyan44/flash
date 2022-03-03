package com.qa.testscripts;

import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.AmazonPages;
import com.qa.utility.ExcelUtility;

public class TC_Amazon_001 extends TestBase{
	
	@Test(dataProvider="getData")
	
	public void searchItem(String Category, String ItemName) throws IOException {
		SoftAssert SAssert = new SoftAssert();
		
		AmazonCC.getCategory().selectByVisibleText(Category);
		AmazonCC.getBox().clear();
		AmazonCC.getBox().sendKeys(ItemName);
		AmazonCC.getMagnify().click();
		boolean status = driver.getTitle().contentEquals(ItemName);
		
		if(status) {
			Reporter.log(" Title of the page has the item name");
			SAssert.assertTrue(status);
			//Assert.assertTrue(status);
			}
	    else {
	    	captureScreenshot(driver,"searchItem");
			Reporter.log("Title of the page incorrect");
			SAssert.assertTrue(status);
			//Assert.assertTrue(status);
			}
		java.util.List<WebElement> getItemName = AmazonCC.getItemName();
		for(WebElement Item:getItemName){
			Reporter.log(Item.getText(),true);
		}
		SAssert.assertAll();
	}
	
	@DataProvider
	public String[][] getData() throws IOException{
		String xFile = "C:\\Users\\giris\\eclipse-workspace\\TestAutomation.Selenium\\src\\test\\java\\com\\qa\\testdata\\TestDataSheet.xlsx";
		String xSheetName = "Sheet1";
		
		int rowCount = ExcelUtility.getRow(xFile, xSheetName);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheetName, rowCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellCount(xFile, xSheetName,i, j);
		
				
			}
		}
		
		
	//	Object[][] data = new Object[3][2];
		//data[0][0]="Books";
		//data[1][0]="Electronics";
		//data[2][0]="Appliances";
		
		
		//data[0][1]="Da vinci code";
		//data[1][1]="Mobiles Phones";
		//data[2][1]="Washing Machines";
		
		
		return data;
		
	}

}

/*WebElement Category = driver.findElement(By.id("searchDropdownBox"));

Select Option = new Select(Category); 
Option.selectByVisibleText("Books");

driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Da vinci code");
driver.findElement(By.id("nav-search-submit-button")).click();
String title = driver.getTitle();
//if(title.contains("Da vinci code")) {
//System.out.println(" Title of the page has the item name");
//}
//else {
//	System.out.println("Title of the page incorrect");
//}

java.util.List<WebElement> AllItems = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'] "));

System.out.println("total no of items searched are : " + AllItems.size());
for( WebElement item: AllItems) {
	System.out.println(item.getText());
	
}
*/
