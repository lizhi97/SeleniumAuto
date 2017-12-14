package com.landesk.avalanche.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.landesk.avalanche.PageObjects.LoginPageObject;
import com.landesk.*;

public class LoginIE {

	public WebDriver ieDriver = DriverFactory.buildDriver(DriverType.IE);

	@Parameters({ "url", "username", "password" })
	@Test
	public void test(String url, String username, String password) {

		LoginPageObject loginPageIE = new LoginPageObject(ieDriver);

		ieDriver.get(url);

		loginPageIE.inputUsername(username);
		loginPageIE.inputPassword(password);
		loginPageIE.clickLoginButton();

		String actualUrl = ieDriver.getCurrentUrl();
		String expectedUrl = "https://staging.aod.wavelink.com/AvalancheWeb/app/inventory.jsf";

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@AfterTest
	public void closeDriver() {
		ieDriver.close();
	}

}