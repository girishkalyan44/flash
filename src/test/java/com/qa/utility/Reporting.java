package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Reporting extends TestListenerAdapter{
	
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports xReports;
	public ExtentTest xTest;
	
	  public void onStart(ITestContext testContext) {
		  
		  String dataStamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
		  String repName = "Test-Automation-Report"+ dataStamp + ".html";
		  htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		  htmlReport.config().setDocumentTitle("Automation Report");
		  htmlReport.config().setReportName("Funtional Test Report");
		  htmlReport.config().setTheme(Theme.DARK);
		  htmlReport.config().setAutoCreateRelativePathMedia(true);
		  
		  xReports = new ExtentReports();
		  xReports.attachReporter(htmlReport);
		  xReports.setSystemInfo("QA Name", "TesterA");
		  xReports.setSystemInfo("Platform", "Win10");
		  
		 
		  
	  }

	  public void onFinish(ITestContext testContext) {
		  
		  xReports.flush();
	  }
	  
	  
	  public void onTestSuccess(ITestResult tr) {
		  
		  xTest = xReports.createTest(tr.getName());
		  xTest.log(Status.PASS, "Test is Passed");
		  xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.BLUE));
	    
	  }

	  public void onTestFailure(ITestResult tr) {
		  

		  xTest = xReports.createTest(tr.getName());
		  xTest.log(Status.FAIL, "Test is Failed");
		  xTest.log(Status.FAIL, tr.getThrowable());
		  xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		  
		  String ssPath = System.getProperty("user.dir")+"/ScreenShot/"+tr.getName()+".png";
		  File file = new File(ssPath);
		  if(file.exists()) {
			  try {
				xTest.fail("ScreensShot For the faoles test is :"+ xTest.addScreenCaptureFromPath(ssPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  
	    
	  }

	  
	  public void onTestSkipped(ITestResult tr) {

		  xTest = xReports.createTest(tr.getName());
		  xTest.log(Status.SKIP, "Test is Skipped");
		  xTest.log(Status.SKIP, tr.getThrowable());
		  xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	  }

}
