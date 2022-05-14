package com.automation.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.automation.utils.DriverUtils.getDriver;
import static com.automation.utils.DriverUtils.tearDown;

import java.io.IOException;

import com.automation.utils.ScreenShotMethods;

public class Hooks {

	ScreenShotMethods takeScreenShotObj = new ScreenShotMethods();

	@Before
	public void setUp() {
		getDriver();
	}

	@After
	public void teardown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			takeScreenShotObj.takeScreenShot();
		}
		tearDown();
	}
}
