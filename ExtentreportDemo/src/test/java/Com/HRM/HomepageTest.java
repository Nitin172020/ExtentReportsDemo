package Com.HRM;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.basepackage.Baseclass;
import com.utility.TakeScreenshotExtent;

public class HomepageTest extends Baseclass {

	@BeforeMethod
	public void launchApp() {

		System.setProperty("webdriver.chrome.driver", "D:\\eclipse data\\CRM\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	public void HomepageLogoTest() {
		test = extentreport.createTest("HomepageTest");
		boolean status = driver.findElement(By.xpath("//div[@id='divLogo']//img")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	@Test
	public void HomepageLoginTest() {
		test = extentreport.createTest("HomepageLoginTest");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Homepage_title = driver.getTitle();
		Assert.assertEquals(Homepage_title, "OrangeHRM1");

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
			//String screenShotPath1=screenshot.TakeScreenShotforExtent(driver,result.getName());
			//test.addScreenCaptureFromPath(screenShotPath1);
			String path_screen=TakeScreenshotExtent.takeScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(path_screen);

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
			
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		driver.close();
	}

}
