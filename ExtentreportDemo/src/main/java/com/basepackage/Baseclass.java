package com.basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Baseclass {
	
	public ExtentHtmlReporter htmlreport;
	public ExtentReports extentreport;
	public ExtentTest test;
	public WebDriver driver;
	
	
	@BeforeSuite
	public void setup()
	{
		
		
		htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/NitinReport/Report.html");
		//htmlreport.loadXMLConfig("D:\\eclipse data\\ExtentreportDemo\\Configuration\\extent-config.xml");
		htmlreport.config().setDocumentTitle("Extent Report Demo");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Orange HRM Report");
		extentreport=new ExtentReports();
		extentreport.attachReporter(htmlreport);
		extentreport.setSystemInfo("OS", "Windows 7");
		extentreport.setSystemInfo("Application name", "Orange HRM");
		extentreport.setSystemInfo("Tester", "Nitin");
		test = extentreport.createTest("HomepageTest");
		
		
	}
	
	
	
	
@AfterSuite
public void flushReport()
{
	extentreport.flush();
}
}
