package com.e2eTests.automatedTests.utils;

public class DriverManagerFactory {

	public static DriverManager getManager(DriverType type) {

		DriverManager driverManager;

		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		default:
			driverManager = new EdgeDriverManager();
			break;
		}
		return driverManager;

	}
}
