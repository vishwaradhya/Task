package com.automation.steps;

import static com.automation.utils.ConfigUtils.getPropertyByKey;
import com.automation.pages.LoginPage;
import com.automation.utils.CommonActions;

import cucumber.api.java.en.Given;

public class LoginPageSteps {
	LoginPage loginPage = new LoginPage();

	@Given("^user launch the Gymondo url$")
	public void launchGymondoUrl(){

		CommonActions.navigateToUrl(getPropertyByKey("application.url"));
	}

	@Given("^user logs into Gymondo app with valid credentials$")
	public void login() {

		loginPage.login(getPropertyByKey("userName"), getPropertyByKey("password"));
	}

}
