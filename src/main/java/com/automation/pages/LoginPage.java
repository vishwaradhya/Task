package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.utils.CommonActions;
import static com.automation.utils.DriverUtils.getDriver;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(className = "login-button-module--wrapper--_Sndu")
	WebElement loginBtn;
	
	@FindBy(id = "mail")
	WebElement userNameId;

	@FindBy(id = "password")
	WebElement passwordId;

	
	@FindBy(className = "btn-gym__content")
	WebElement submitBtn;
	
	
	public void login(String userName,String passWord) {

		CommonActions.clickOnElement(loginBtn);
		CommonActions.sendKeysTo(userNameId, userName);
		CommonActions.sendKeysTo(passwordId, passWord);
		CommonActions.clickOnElement(submitBtn);
	}

}
