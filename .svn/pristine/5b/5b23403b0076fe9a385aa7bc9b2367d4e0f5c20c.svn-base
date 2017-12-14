package com.landesk.ldms.webconsole.PageObjectsForIE;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.landesk.PageBaseForIE;
import com.landesk.ldms.Utils.util;

public class QuerySortPageObject extends PageBaseForIE {

	private util ut = new util();

	public QuerySortPageObject(WebDriver driver) {
		
		this.driver = driver;
		waitForPageLoaded(this.driver);
	}

	public void goToSelectSort() {
		waitAndClickElement(driver,
				By.xpath(".//*[@id='currAttr']/tbody/tr[1]/td"), 50);
	}

	public void goToSelectSec() {
		waitAndClickElement(driver,
				By.xpath(".//*[@id='currAttr']/tbody/tr/td"), 50);
	}

	public void goToClickAddButton() {
		
		//waitAndClickElement(driver, By.id("_btnAddItem"), 50);
		((JavascriptExecutor) driver).executeScript("javascript:addItem();");
	}

	public void goToClickOKButton() {
		waitAndClickElement(driver,
				By.xpath(".//*[@id='query']/table/tbody/tr[4]/td/input[1]"), 50);
	}

	public void openWindow() {

		String newhandle = ut.switchWindow(driver);
		driver.switchTo().window(newhandle);// switch new window
		this.setDriver(driver);
	}

}
