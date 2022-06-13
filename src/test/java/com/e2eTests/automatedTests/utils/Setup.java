package com.e2eTests.automatedTests.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Setup {
	
	public static WebDriver driver; 
	static DriverManager driverManger;
	
	@Before 
	/*
	 * Call browser with the design pattern factory navigator
	  */
	public static void setup() {
		driverManger = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManger.getDriver();
	}
	
	@After
	/*
	 * Embed a screenshot in test report if is test is marked as failed
	  */
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				scenario.write("current page url is " +driver.getCurrentUrl() );
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}catch(WebDriverException somPlateformDontSupportScreenshots) {
				System.err.println(somPlateformDontSupportScreenshots.getMessage());
			}
		}
		driver.quit();
		
	}
	
	
}

