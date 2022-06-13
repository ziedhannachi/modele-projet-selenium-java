package com.e2eTests.automatedTests.utils;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	protected void startService() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "src/test/resources/BrowserDriver/MicrosoftWebDriver.exe");
	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createDriver() {
		// TODO Auto-generated method stub
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

}
