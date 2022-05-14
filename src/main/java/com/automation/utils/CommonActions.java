package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.automation.utils.ConfigUtils.getPropertyByKey;
import static com.automation.utils.WaitUtils.waitForVisible;

public class CommonActions extends DriverUtils {
	
	public static void clickOnElement(WebElement element) {
		waitForVisible(element);
		element.click();
	}

	public static void sendKeysTo(WebElement element, String text) {
		waitForVisible(element);
		element.clear();
		element.sendKeys(text);
	}

	public static WebElement prepareWebElement(String element) {

		return driver.findElement(By.xpath(element));
	}
	
	public static void navigateToUrl(String url) {
		
		driver.get(getPropertyByKey("application.url"));
	}

	public static String prepareWebElement(String element,String attribute) {

		return driver.findElement(By.xpath(element)).getAttribute(attribute);
	}
	
	public static boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		}catch (Exception e) {
			return false;
		}
		
	}
	
}
