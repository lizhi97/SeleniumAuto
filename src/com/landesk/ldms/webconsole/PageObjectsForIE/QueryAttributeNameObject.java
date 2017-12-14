package com.landesk.ldms.webconsole.PageObjectsForIE;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.landesk.PageBaseForIE;
import com.landesk.ldms.Utils.util;

public class QueryAttributeNameObject extends PageBaseForIE {

	private util ut = new util();

	public QueryAttributeNameObject(WebDriver driver) {
		
		this.driver = driver;
		waitForPageLoaded(this.driver);
	}

	public void goToAttrQueryTreeFrame() {
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "attrselectquerytree", 50);
	}
	
	public void goToAttrFrame() {
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "attrselectattributes", 50);
	}
	public void selectDeviceID(){
		goToAttrQueryTreeFrame();
		waitAndGetElement(driver, By.xpath(".//*[@id='8item']"), 50);
		waitAndClickElement(driver, By.xpath(".//*[@id='8item']"), 50);
	}
	public void selectDeviceName(){
		goToAttrQueryTreeFrame();
		waitAndGetElement(driver, By.xpath(".//*[@id='9item']"), 50);
		waitAndClickElement(driver, By.xpath(".//*[@id='9item']"), 50);
	}
	//public void selectAttributes() {
		//goToAttrQueryTreeFrame();
		//waitAndClickElement(driver,
				//By.xpath(".//*[@id='myList']/tbody/tr[3]/td"), 50);
	//}

	//public void selectAssetTag() {
		//waitAndClickElement(driver, By.id("0item"), 50);
	//}

	public void goToClickAddButton() {
		goToAttrFrame();
		//waitAndClickElement(driver, By.id("btnAdd"), 50);
		((JavascriptExecutor) driver).executeScript("javascript:addItem();");
		
	}

	//public void selectBroad() {
	//	goToAttrQueryTreeFrame();
		//waitAndClickElement(driver, By.id("1item"), 50);
	//}

	public void goToClickOKButton() {
		goToAttrFrame();
		waitAndClickElement(driver,
				By.xpath(".//*[@id='selData']/table/tbody/tr[6]/td/input[1]"),
				50);
	}

	public void openWindow() {

		String newhandle = ut.switchWindow(driver);
		driver.switchTo().window(newhandle);// switch new window
		this.setDriver(driver);
	}

}
