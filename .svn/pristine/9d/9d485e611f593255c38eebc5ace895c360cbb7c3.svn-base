package com.landesk.ldms.webconsole.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.landesk.PageBase;
import com.landesk.ldms.Utils.util;

public class QueryDialogNameObject extends PageBase {

	private util ut = new util();

	public QueryDialogNameObject(WebDriver driver) {
		
		this.driver = driver;
		waitForPageLoaded(this.driver);
	}
	
	public void goToComputerLeftFrame() {
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "tree", 50);

	}

	public void selectDeviceName() {
		waitAndClickElement(driver, By.xpath("//td[contains(text(),'Device Name')]"), 50);
	}

	public void goToConditionFrame() {
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "config", 50);
		waitAndSwitchToFrame(driver, "dialog", 50);
	}

	public void selectExistValue(String ComputerName){
		
		new Select(waitAndGetElement(driver,By.id("_val"),50)).selectByVisibleText(ComputerName);
		
	}

	public void selectBool(){
		
		new Select(waitAndGetElement(driver,By.id("boolOp"),50)).selectByIndex(1);
	}

	public void goToAddFrame() {
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "config", 50);
		waitAndSwitchToFrame(driver, "selected", 50);
	}

	public void ClickAddButton() {
		//waitAndClickElement(driver, By.xpath(".//*[@id='btnAdd']"), 50);
		((JavascriptExecutor) driver).executeScript("javascript:addItem('add');");
		
	}

	public void ClickOKButton() {
		waitAndClickElement(driver,
				By.xpath(".//*[@id='selData']/table/tbody/tr[3]/td/input[1]"),
				50);
	}

	public void openWindow() {

		String newhandle = ut.switchWindow(driver);
		driver.switchTo().window(newhandle);// switch new window
		this.setDriver(driver);
	}

}
