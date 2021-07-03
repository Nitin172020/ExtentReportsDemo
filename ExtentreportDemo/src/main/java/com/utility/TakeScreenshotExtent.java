package com.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshotExtent {

	public static String takeScreenshot(WebDriver driver, String filename) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		

		File source_screen = screenshot.getScreenshotAs(OutputType.FILE);
String destination_screens="D:\\eclipse data\\ExtentreportDemo\\Screenshots\\" + filename + ".png";
		try {

			FileUtils.copyFile(source_screen,
					new File(destination_screens));

		} catch (Exception e) {

			e.getMessage();
		}
		return destination_screens;
	}
	

}
