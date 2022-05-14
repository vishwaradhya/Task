package com.automation.steps;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.automation.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {
	HomePage homePage = new HomePage();

	@Given("^user verifies successful login page for Gymondo home page$")
	public void verifiyGymondoHomePage() {
		
		homePage.clearDefaultPopUp();
		assertTrue("Home page is not displayed !!!!", homePage.verifyHomePage());
	}


	@Given("^user opens plan settings$")
	public void openPlanSettings() {

		homePage.openPlanSettings();
	}

	@Given("^user verifies that plan settings is launched successfully$")
	public void verifyPlanSettings()  {

		assertTrue("Default page is not displayed !!!!", homePage.verifyPlanSettings());

	}

	@When("^user sets following workout days \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void selectWorkDays(String monday, String tuesday, String wednesday, String thursday, String friday,
			String saturday, String sunday) {

		Map<String, String> weekdays = new HashMap<String, String>();
		weekdays.put("Mo", monday);
		weekdays.put("Tu", tuesday);
		weekdays.put("We", wednesday);
		weekdays.put("Th", thursday);
		weekdays.put("Fr", friday);
		weekdays.put("Sa", saturday);
		weekdays.put("Su", sunday);

		homePage.selectWorkDays(weekdays);

	}

	@When("^user saves the workout settings$")
	public void savePlanSettings() {

		homePage.savePlanSettings();
	}

	@Then("^user verifies following workout days \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" are updated in the calendar$")
	public void verifyWorkDay(String monday, String tuesday, String wednesday, String thursday, String friday,
			String saturday, String sunday) {

		Map<String, String> weekdays = new HashMap<String, String>();
		weekdays.put("Mo", monday);
		weekdays.put("Tu", tuesday);
		weekdays.put("We", wednesday);
		weekdays.put("Th", thursday);
		weekdays.put("Fr", friday);
		weekdays.put("Sa", saturday);
		weekdays.put("Su", sunday);
		
		Map<String, String> results = new HashMap<String, String>();
		results = homePage.verifyWorkDay(weekdays);
		
		assertTrue("Seems like workdays are not as per plan settings please check !!!", !results.containsValue("Fail"));
	}

	@Then("^user logs out of Gymondo app$")
	public void logout()  {

		homePage.logout();
	}

}
