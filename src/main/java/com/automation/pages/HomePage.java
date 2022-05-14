package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.utils.CommonActions;
import static com.automation.utils.DriverUtils.getDriver;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(className = "login-button-module--wrapper--_Sndu")
	WebElement loginBtn;

	@FindBy(id = "mail")
	WebElement userNameId;

	@FindBy(className = "header_greeting__B-XLP")
	WebElement headerLabel;

	@FindBy(xpath = "//div[@class='btn-gym__content' and contains(text(),'Plan settings')]")
	WebElement planSettingBtn;

	@FindBy(className = "program-training-settings_programTitle__Lebz+")
	WebElement planSettingTitle;

	@FindBy(className = "modal_closeIcon__ZIDaj")
	WebElement defaultPopup;

	@FindBy(xpath = "//div[@class='btn-gym__content' and contains(text(),'Save')]")
	WebElement savePlanSettingBtn;

	@FindBy(className = "user-dropdown_userImg__Re66m")
	WebElement accountBtn;

	@FindBy(className = "user-actions_logoutBtn__yO7+T")
	WebElement logoutBtn;

	@FindBy(xpath = "//button[@class='btn-gym btn--small btn--disabled']")
	WebElement saveDisable;

	@FindBy(className = "modal_closeIcon__ZIDaj")
	WebElement closeIcon;

	@FindBy(xpath = "//div[contains(text(),'Enjoy your rest day!')]")
	WebElement enjoyDayLabel;

	public String weekday = "//button[contains(text(),'<replace>')]";

	public String workday = "//div[contains(text(),'<replace>')]";

	public void selectWorkDays(Map<String, String> weekdays) {

		for (Map.Entry<String, String> set : weekdays.entrySet()) {
			String temp = CommonActions.prepareWebElement(weekday.replace("<replace>", set.getKey()), "aria-selected");
			if (set.getValue().equalsIgnoreCase("YES")) {
				if (!temp.equalsIgnoreCase("true")) {
					CommonActions.prepareWebElement(weekday.replace("<replace>", set.getKey())).click();
				}
			} else {
				if (temp.equalsIgnoreCase("true")) {
					CommonActions.prepareWebElement(weekday.replace("<replace>", set.getKey())).click();
				}
			}
		}
	}

	public Map<String, String> verifyWorkDay(Map<String, String> weekdays) {

		Format dayformat = new SimpleDateFormat("EEEE");
		String today = dayformat.format(new Date());

		// update Hash map with Today

		for (Map.Entry<String, String> set : weekdays.entrySet()) {

			if (today.contains(set.getKey())) {
				weekdays.remove(set.getKey());
				weekdays.put("Today", set.getValue());

			}

		}

		Map<String, String> results = new HashMap<String, String>();

		for (Map.Entry<String, String> set : weekdays.entrySet()) {
			CommonActions.prepareWebElement(workday.replace("<replace>", set.getKey())).click();
			if (set.getValue().equalsIgnoreCase("YES")) {
				if (CommonActions.isDisplayed(enjoyDayLabel)) {
					results.put(set.getKey(), "Fail");
				} else {
					results.put(set.getKey(), "Pass");
				}
			} else {
				if (!CommonActions.isDisplayed(enjoyDayLabel)) {
					results.put(set.getKey(), "Fail");
				} else {
					results.put(set.getKey(), "Pass");
				}
			}
		}

		return results;

	}

	public void openPlanSettings() {

		CommonActions.clickOnElement(planSettingBtn);
	}

	public boolean verifyPlanSettings() {
		return CommonActions.isDisplayed(planSettingTitle);
	}

	public void savePlanSettings() {

		System.out.println("CommonActions.isDisplayed(saveDisable " + CommonActions.isDisplayed(saveDisable));
		if (CommonActions.isDisplayed(saveDisable)) {
			CommonActions.clickOnElement(closeIcon);
		} else {
			CommonActions.clickOnElement(savePlanSettingBtn);
		}

	}

	public void logout() {

		CommonActions.clickOnElement(accountBtn);
		CommonActions.clickOnElement(logoutBtn);

	}

	public boolean verifyHomePage() {
		return CommonActions.isDisplayed(headerLabel);
	}

	public void clearDefaultPopUp() {

		CommonActions.clickOnElement(defaultPopup);
	}

}
