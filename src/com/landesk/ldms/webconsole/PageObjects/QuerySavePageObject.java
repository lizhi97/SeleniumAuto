package com.landesk.ldms.webconsole.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.landesk.PageBase;
import com.landesk.ldms.Utils.util;

public class QuerySavePageObject extends PageBase {

	private util ut = new util();
	//private String queryName;
	public QuerySavePageObject(WebDriver driver) {
		
		this.driver = driver;
		waitForPageLoaded(this.driver);
	}

	public void inputQueryName(String queryName) {
       
		waitAndGetElement(driver, By.xpath(".//*[@id='queryName']"), 60)
				.sendKeys(queryName);
		

	}

	public void clickSaveButton() {
		waitAndClickElement(driver,
				By.xpath(".//*[@id='_dlgData']/table/tbody/tr[7]/td/input[1]"),
				50);
	}

	public void openWindow() {

		String newhandle = ut.switchWindow(driver);
		driver.switchTo().window(newhandle);// switch new window
		this.setDriver(driver);
	}
	

}
