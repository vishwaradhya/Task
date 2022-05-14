package com.automation.utils;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static com.automation.utils.ConfigUtils.getPropertyByKey;
import static com.automation.utils.ConfigUtils.loadProperties;

/**
 * Author : Vishwaradhya Invoke WebDriver
 */
public class DriverUtils {
	static WebDriver driver;

	public static void initDriver() {
		loadProperties();

		switch (getPropertyByKey("browser")) {
		case "Firefox":

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setLogLevel(FirefoxDriverLogLevel.TRACE);
			options.addPreference("toolkit.asyncshutdown.log", true);
			driver = new FirefoxDriver(options);
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			break;

		}

		driver.manage().window().maximize();

	}

	public static WebDriver getDriver() {

		if (driver == null) {
			initDriver();
		}
		return driver;
	}

	public static void tearDown() {
		driver.quit();
		driver = null;
	}
}
